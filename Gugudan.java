import java.util.stream.IntStream;
import java.util.stream.Collector;
class Gugudan {
    public static void main(String[] args) {
        
        String tempString = "%d X %d = %d";

		// 짝수단 출력하기
        for(int x = 2; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
				if(y % 2 == 0)
                	System.out.println(String.format(tempString, x, y, x*y));
            }
        } 

		//짝수단 출력하기 스트림 사용하기		
        IntStream
            .rangeClosed(2, 9)
            .filter(a -> a % 2 == 0)
            .forEach(x -> IntStream
                .rangeClosed(1, 9)
                .forEach(y -> System.out.println(String.format(tempString, x, y, x*y))));

		// 2단~9단 가로로 출력하기1
        for (int i=2; i < 10; i++) {
			for (int j=1; j < 10; j++) {
				System.out.print(String.format(tempString, i,j,i*j));
				
				if (j < 9) {
					System.out.print("\t");
				}
			}
			
			System.out.println();
		}
		
		// 2단~9단 가로로 출력하기2
		String[] values = new String[9];
		
		
		for (int i=2; i < 10; i++) {
			for (int j=1; j < 10; j++) {
				values[j - 1] = String.format(tempString, i,j,i*j);
			}
			
			System.out.println(String.join("\t", values));
		}
		
		// 2단~9단 가로로 출력하기 스트림 사용하기
		IntStream.range(2, 10)
		.mapToObj(a -> 
			IntStream.range(1, 10)
			.mapToObj(b -> String.format(tempString, a,b,a*b))
			.collect(Collectors.joining("\t"))
			.toString()
		).forEach(System.out::println);
    }
}
