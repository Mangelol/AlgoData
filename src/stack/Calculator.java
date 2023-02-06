package stack;

public class Calculator {
	Item[] expr; //Arithmetic expressions represented as an arrya of items
	int ip; //instruction pointer
	StaticStack stack; //The stack?
	//DynamicStack stack;
	
	
	public Calculator(Item[] expr) {
		this.expr = expr;
		this.ip = 0;
		//this.stack = new StaticStack();
		this.stack = new StaticStack();
	}

	//add code
	public int run() {
		while(ip < expr.length) { //While instruction pointer is less than the length of expr
			step(); //One step at a time
		}
		return stack.pop();
	}
	
	
	public void step() {
			Item nxt = expr[ip++];
		
			switch(nxt.getType()) { //Choose which type
		
			case ADD : {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x + y);
				break;
			}
			case SUB : {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x - y);
				break;
			}
			case MUL : {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x * y);
				break;
			}
			case DIV : {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x / y);
				break;
			}
			case VALUE : {
				int x = nxt.getValue();
				stack.push(x);
				break;
		}
			
		}
	}
}
