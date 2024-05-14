package contact.lib;

import java.util.ArrayList;

class NumberException extends Exception {
    public NumberException(String msg) {
        super(msg);
    }
}

class RelationException extends Exception {
    public RelationException(String msg) {
        super(msg);
    }
}


public class Exceptions {
	public int NumberException(String number) {
		int num=0;
		try {
			if (number.matches("^010\\d{8}$")) {
				return 1;
			}
			else {				
				throw new NumberException("올바른 형식을 입력하세요!");
			}
		} catch(NumberException e) {
			System.out.println(e.getMessage());
		}
		return num;
	}
	public int RelationException(String relation, ArrayList<String> list) {
		int num=0;
		try {
			for (String s: list) {
				if(s.equals(relation)) {
					num=1;
				}
			}
			if(num==0) {
				throw new RelationException("올바른 형식을 입력하세요!");
			}
		} catch(RelationException e) {
			System.out.println(e.getMessage());
		}
		return num;
	}
}
