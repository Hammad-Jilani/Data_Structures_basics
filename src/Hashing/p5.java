package Hashing;

public class p5 {
    public static void interchange(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static int findIndex(char[] arr, char a, int min) {
        for (int i = min; i < arr.length; i++) {
            if(arr[i] == a){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        char[] sequence = {'!', '#', '$', '%', '&', '*', '@', '^', '~'};
        char[] bolts = {'%','@','#', '$', '^'};
        char[] nuts = {'@','%','$','#','^'};

        int forNuts = 0;
        int forBoults = 0;
        for (int i = 0; i < sequence.length; i++) {
            int check = findIndex(nuts, sequence[i], i);
            if(check != -1) {
                int k = findIndex(bolts, sequence[i], i);
                interchange(nuts,forNuts,check);

                interchange(bolts,forBoults,k);

                forNuts+=1;
                forBoults+=1;
            }
        }
        System.out.print("Bolts: ");
        for (int i=0;i<nuts.length;i++) {
            System.out.print(bolts[i] + " ");
        }
        System.out.println();
        System.out.print("Nuts: ");
        for (int i=0;i<nuts.length;i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println();
    }
}