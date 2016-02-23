package quicksortnotrecursively;

import java.util.Scanner;

public class QuickSortNotRecursively {
static Scanner input = new Scanner(System.in);
 
    static void quickSort(int l, int r, long [] tab) {
        int i = 0;
        while(l < r || i > 0)
        {
            if(l < r)
            {
                int q = partition(l, r, tab);
                tab[r] = -tab[r];
                r = q;
                i++;
            }
            else
            { 
                l = r + 1;   
                r = l; 
                while(tab[r] > 0)
                    r++;
                tab[r] = -tab[r];  
                i--;
            }
        }
    }
 
    private static int partition(int l, int r, long[] tab) {
        int i = l;
        int j = r;
        long pivot;
        swap(l, (l + r) / 2, tab);
        pivot = tab[l];
 
        while (true) {
            while (tab[j] > pivot)//szuka mniejszego (badz rownego) od pivota (od prawego przedzialu w dol)
                j--;
            while (tab[i] < pivot)//szuka wiekszego (badz rownego) od pivota (od lewego w gore)
                i++;
            if (i < j) { //jesli liczba wieksza ma mniejszy index to je zamien i lec dalej
                swap( i ,j, tab);
                i++;
                j--;
            } else // gdy i >= j return j jako punkt podzialu tablicy
                return j;
        }
    }
 
    static void swap(int i, int j,long []tab) {
        long tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    public static void main(String[] args) {
        int n=input.nextInt();
        for(int i=0;i<n;i++)
        {
            int m=input.nextInt();
            long []A=new long[m];
            
            for(int j=0;j<m;j++)
                A[j]=input.nextLong();
            quickSort(0,A.length-1,A);
            for(int j=0;j<m;j++)
                System.out.print(A[j]+" ");
            System.out.println();
        }   
    }
}
