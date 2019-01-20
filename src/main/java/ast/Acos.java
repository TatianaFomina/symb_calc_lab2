package ast;

import computator.Computator;
import visitor.Visitor;
import writer.Writer;

public class Acos extends UnaryOperation {

	public Acos(Operation op) {
		super(op);
	}


	public String toString(){
		return "acos(" + op.toString() + ")";
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
	public Operation accept(Computator c) {
		return c.compute(this);
	}
	@Override
	public Double getNumericResult(Double val) {
		return Math.acos(op.getNumericResult(val));
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Acos)) return false;
		Acos abs = (Acos) o;
		return (op.equals(abs.op));
	}


	public int hashCode(){
		return 11 * op.hashCode();
	}
}
