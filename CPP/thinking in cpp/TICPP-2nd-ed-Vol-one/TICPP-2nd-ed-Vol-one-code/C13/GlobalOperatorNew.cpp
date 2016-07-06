#include<iostream>
 
using namespace std;

void* operator new(size_t sz) 
{
  cout<<"operator new: %d Bytes\n"<<sz;
  void* m = malloc(sz);

  if(!m)
	  cout<<"out of memory";
  return m;
}

void operator delete(void* m) 
{
  cout<<"operator delete";
  free(m);
}

class S 
{
  int i[100];
public:
  S()
  { 
	  cout<<"S::S()";
  }
  ~S() 
  {
	  cout<<"S::~S()"; 
  }
};

int main() 
{
  cout<<"creating & destroying an int";
  int* p = new int(4);
  delete p;
} 
