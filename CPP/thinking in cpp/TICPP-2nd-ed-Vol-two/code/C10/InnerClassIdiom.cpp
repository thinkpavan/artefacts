#include <iostream>
#include <string>
using namespace std;

class A {
public:
  virtual void showA() = 0;
};

void callshowA(A& p) {
  p.showA();
}

class B {
public:
  virtual void showB() = 0;
};

void callshowB(B& b) {
  b.showB();
}

class Outer {

	string name;
  
	// Define one inner class:
 
	class Inner1;
  
	friend class Outer::Inner1;
  
	class Inner1 : public A 
	{
		Outer* parent;
  public:
		Inner1(Outer* p) : parent(p) {}
    
		void showA() {
			cout << "showA called for "<< parent->name << endl;
		// Accesses data in the outer class object
		}
	} inner1;
  // Define a second inner class:
  
	class Inner2;
	
	friend class Outer::Inner2;
  
	class Inner2 : public B 
	{
		Outer* parent;
	public:
		Inner2(Outer* p) : parent(p) {}
		void showB() {
			cout << "showB called for "<< parent->name << endl;
		}
	} inner2;
public:
  Outer(const string& nm): name(nm), inner1(this), inner2(this) {}
  // Return reference to interfaces
  // implemented by the inner classes:
  operator A&() { return inner1; }
  operator B&() { return inner2; }
};

int main() {
  Outer x("Welcome");
  // Like upcasting to multiple base types!:
  callshowA(x);
  callshowB(x);
} ///:~
