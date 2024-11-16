    package 이분탐색.풀어야할문제.숫자카드_10815_실버5;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class 홍창모 {
        static int n, m;

        static int[] nCard, mCard;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());

            nCard = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for( int i = 0; i < n; i++ ) {
                nCard[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());

            mCard = new int[m];

            st = new StringTokenizer(br.readLine());

            for( int i = 0; i < m; i++ ) {
                mCard[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nCard);

            StringBuilder sb = new StringBuilder();

            for( int i = 0; i < m; i++ ) {
                int usingCard = binarySearch(mCard[i]);
                sb.append(usingCard).append(" ");
            }

            System.out.print( sb.toString().trim() );

        }

        public static int binarySearch( int target ) {

            int lt = 0, rt = n-1;

            while( lt <= rt ) {
                int mid = lt + (rt - lt) / 2;

                if( nCard[mid] == target ) {
                    return 1;
                } else if( nCard[mid] < target ) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }

            return 0;
        }
    }
