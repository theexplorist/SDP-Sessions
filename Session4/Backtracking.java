
public class Backtracking {

	public static void shreyKaKarnama(boolean[] akhilHouse, int rN) {
		if(rN == akhilHouse.length) { //rN == 3
			return;
		}
		akhilHouse[rN] = true; //topi
		shreyKaKarnama(akhilHouse, rN + 1);
		akhilHouse[rN] = false; //backtracking
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] akhilHouse = new boolean[3];
		for(boolean room : akhilHouse) {
			System.out.println(room);
		}
		
		shreyKaKarnama(akhilHouse, 0);
		System.out.println("shrey ke karname karne ke baad");
		for(boolean room : akhilHouse) {
			System.out.println(room);
		}
		
	}

}
