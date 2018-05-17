
public class StringConverter {
	String ori;
	
	StringConverter(){
		this.ori = "original";
	}
	
	public String convertStr(String s){
		String toReturn = s.concat(ori);
		return toReturn;
	}
}
