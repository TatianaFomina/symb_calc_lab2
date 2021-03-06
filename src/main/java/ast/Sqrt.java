package ast;

import visitor.Visitor;
import writer.Writer;

public class Sqrt extends UnaryOperation {
	
	public Sqrt(Operation op) {
		super(op);
	}



	public String toString(){
		return "sqrt(" + op.toString() + ")";
 	}

	@Override
	public Operation accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public String acceptWriter(Writer w) {
		return w.visit(this);
	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.sqrt(op.getNumericResult(val));
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Sqrt)) return false;
		Sqrt abs = (Sqrt) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 53 * op.hashCode();
	}
}
