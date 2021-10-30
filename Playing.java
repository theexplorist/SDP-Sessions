import java.util.*;

public class Main {

    static final int MAX = 1299709; // 10^5 th prime number
    static boolean[] sieve = new boolean[MAX];
    static ArrayList<Integer> primes = new ArrayList<>();

    static void createSieve() {
        for (int i = 0; i < MAX; i++) {
            sieve[i] = true;
        }
        sieve[0] = sieve[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = i * i; j < MAX && j >= 0; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        primes.add(1); // Putting 1 as 0th prime number (even though its not)
        createSieve();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int size = q + 1;
        ArrayList<Stack<Integer>> a = new ArrayList<>();
        ArrayList<Stack<Integer>> b = new ArrayList<>();

        a.add(new Stack<Integer>());
        b.add(new Stack<Integer>());

        while (n-- > 0) {
            int x = sc.nextInt();
            a.get(0).push(x);
        }

        for (int i = 1; i <= q; i++) {
            a.add(new Stack<>());
            b.add(new Stack<>());
            while (!a.get(i - 1).empty()) {
                int topElement = a.get(i - 1).peek();
                a.get(i - 1).pop();
                if (topElement % primes.get(i) == 0) {
                    b.get(i).push(topElement);
                } else {
                    a.get(i).push(topElement);
                }
            }
        }

        // Print b stacks first ...then a stacks
        for (int i = 0; i < size; i++) {
            while (!b.get(i).empty()) {
                System.out.println(b.get(i).peek());
                b.get(i).pop();
            }
        }
        for (int i = 0; i < size; i++) {
            while (!a.get(i).empty()) {
                System.out.println(a.get(i).peek());
                a.get(i).pop();
            }
        }

    }
}

///////////////////

import java.util.*;

public class Main {

    static final int MAX = 1299709; // 10^5 th prime number
    static boolean[] sieve = new boolean[MAX];
    static ArrayList<Integer> primes = new ArrayList<>();

    static void createSieve() {
        for (int i = 0; i < MAX; i++) {
            sieve[i] = true;
        }
        sieve[0] = sieve[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = i * i; j < MAX && j >= 0; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        createSieve();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        Stack<Integer> s = new Stack<>();

        while (n-- > 0) {
            int d = sc.nextInt();
            s.push(d);
        }
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= q; i++) {
            while (!s.empty()) {
                int x = s.peek();
                int y = primes.get(i - 1);
                if (x % y == 0) {
                    b.push(x);
                } else {
                    a.push(x);
                }
                s.pop();
            }
            while (!b.empty()) {
                int x = b.peek();
                qu.add(x);
                b.pop();
            }
            s = a;
            a = new Stack<>();
        }
        while (!qu.isEmpty()) {
            System.out.println(qu.poll());
        }
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
