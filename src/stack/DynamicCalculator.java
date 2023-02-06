package stack;

public class DynamicCalculator {
	Item[] expr; //Arithmetic expressions represented as an arrya of items
	int ip; //instruction pointer
	DynamicStack stack;
	
	
	public DynamicCalculator(Item[] expr) {
		this.expr = expr;
		this.ip = 0;
		this.stack = new DynamicStack();
	}

	//add code
	public int run() {
		while(ip < 31) { //While instruction pointer is less than the length of expr
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
			case MOD : {
				int y = stack.pop();
				y = y % 10;
				stack.push(y);
				break;
			}
			case WMUL : {
				int y = stack.pop();
				int x = stack.pop();
				
				if(((y * x) / 10) == 1) {
					stack.push(1 + (y * x) % 10);
				}
				else {
					stack.push(x * y);
				}
				break;
			}
		}
	}
}

