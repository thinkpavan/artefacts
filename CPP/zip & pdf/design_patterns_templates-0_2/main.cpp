#include <windows.h>

#include <string>
#include <vector>

#include "composite.h"
#include "singleton.h"
#include "factory.h"
#include "decorator.h"

void singleton_test()
{
  typedef template_patterns::singleton<std::string> stringleton;

  (*stringleton()) = "foo";
  OutputDebugString((*stringleton()).c_str());
  OutputDebugString("\n");
}

void factory_test()
{
  typedef template_patterns::factory<std::string, std::string> stractory;

  std::vector<std::string*> string_vector;

  string_vector.push_back(stractory::create()); (*string_vector.back()) = "first";
  string_vector.push_back(stractory::create()); (*string_vector.back()) = "second";
  string_vector.push_back(stractory::create()); (*string_vector.back()) = "third";
  string_vector.push_back(stractory::create()); (*string_vector.back()) = "fourth";

  for (std::vector<std::string*>::const_iterator i=string_vector.begin(); i!=string_vector.end(); ++i)
  {
    OutputDebugString((*i)->c_str());
    OutputDebugString("\n");
  }
}



class decorator_test_class
{
private:
  std::string content;
public:
  void set_content(const std::string new_content) 
  {
    content = new_content;
  }

  void execute(decorator_test_class &caller)
  {
    OutputDebugString(content.c_str());
  }
};


void decorator_test()
{
  typedef template_patterns::decorator<decorator_test_class> stractorator;

  stractorator base; base.set_content("the ");
  stractorator sub_1; sub_1.set_content("whitefox ");
  stractorator sub_2; sub_2.set_content("jumps over the fence");
  stractorator sub_3; sub_3.set_content("\n");

  base.decorate(sub_1);
  base.decorate(sub_2);
  base.decorate(sub_3);

  base.perform();
}

class composite_test_class
{
private:
  std::string content;
public:
  void set_content(const std::string &new_content)
  {
    content = new_content;
  }

  void execute(composite_test_class &caller)
  {
    OutputDebugString(content.c_str());
  }
};


void composite_test()
{
  typedef template_patterns::composite<composite_test_class> stromposite;

  stromposite base; base.set_content("the white fox:\n");
  stromposite sub_1; sub_1.set_content(" jumps");
  stromposite sub_1_1; sub_1_1.set_content(" over the white fence\n");
  stromposite sub_2; sub_2.set_content(" runs");
  stromposite sub_2_2; sub_2_2.set_content(" into the black fence\n");

  sub_1.add(sub_1_1);
  sub_2.add(sub_2_2);

  base.add(sub_1);
  base.add(sub_2);

  base.perform();
}

class string_initializer
{
public:
  std::string * operator() (std::string *input)
  {
    (*input) = "I have been initialized";
    return input;
  }
};

void singleton_factory_test()
{
  typedef template_patterns::factory_with_initializer<std::string, std::string, string_initializer> string_factory;
  typedef template_patterns::singleton<string_factory> string_singleton_factory;

  std::string *foo = (*string_singleton_factory()).create();

  OutputDebugString(foo->c_str());
  OutputDebugString("\n");

  delete foo;
}

int main(int argc, char**argv)
{
  singleton_test();
  factory_test();
  decorator_test();
  composite_test();
  singleton_factory_test();
  return 0;
}