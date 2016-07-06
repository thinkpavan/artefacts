 
#include <exception>
#include <iostream>
#include <cstdlib>
using namespace std;
void terminator()
{
	cout << "I'll be back!" << endl;
	abort();
}
void (*old_terminate)() = set_terminate(terminator);
class Botch 

{
public:
class Fruit {};
void f() {
cout << "Botch::f()" << endl;
throw Fruit();
}

~Botch() { throw 'c'; }
};
int main() {
try{
Botch b;
b.f();
} catch(...) {
cout << "inside catch(...)" << endl;
}
} ///:~