package massCalculator;



//this class provide the methods to find out the molecular mass of a formula
public class MassCalculator {

	private static final String CARBON_MASS = "12";
	private static final String HYDROGEN_MASS = "1";
	private static final String OXYGEN_MASS = "16";
	private ExpCalculator evaluteExp = new ExpCalculator();
	
	//return the mass of atoms
	//@param- symbol of atom like h for hydrogen or c for carbon etc.
	String atomicMass(char atom){
		if(atom=='c') return CARBON_MASS;
		if(atom=='o') return OXYGEN_MASS;
		if(atom=='h') return HYDROGEN_MASS;
		return null;
	}
	
	
	//return the mass of the molecular formula
	public int getMass(String formula){
		String exp="";
		int formulaLength = formula.length();
		
		//this loop generates a mathematical expression for further evaluation
		for(int index=0;index<formulaLength;index++){
			char ch = formula.toLowerCase().charAt(index);
			if( ch == 'c' || ch == 'h' || ch == 'o' ){
				if(exp=="" || exp.endsWith("("))
					exp+=atomicMass(ch);
				else
					exp+="+"+atomicMass(ch);
			}
			else if(ch >='1' && ch <= '9'){
				String number =""+ch;
				index++;
				if(index<formulaLength){
				char nextChar = formula.charAt(index); 
				while(nextChar>='1' && nextChar<='9'){
					number+=nextChar;
					index++;
					if(index<formulaLength){
						nextChar = formula.charAt(index);
					}
				}
				index--;
				}
				exp+='*'+number;
			}
			else if(ch=='('){
				exp+="+"+ch;
			}
			else if(ch==')'){
				exp+=ch;
			}
		}
		return evaluteExp.evaluate(exp); //evaluating the generated expression using previous assignment
	}
}
