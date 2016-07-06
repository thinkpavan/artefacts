#include<iostream>
using namespace std;

class ConstCastTest{
	int number;
public:
	void setNumber(int num){
		number = num ;
	}

	void getNumber() const {
		return number;
	}
	
	void printNumber() const {
		cout<<"Number after modification";
		const_cast<ConstCastTest *>(this)->number -- ;
		cout<<number<<endl;
};


int main(){
	ConstCastTest x ;
	x.setNumber(8);
	cout<<"Initial Value number "<<x.getNumber();
	x.printNumber();
	return  0;

}
