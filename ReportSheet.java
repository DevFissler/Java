package p41;

public class ReportSheet {

	public static void main(String[] args) {

		int k23_iPerson = 1; // 전체 인원수 200
		int k23_iPages = 6; // 한 페이지에 출력할 인원 30
		int k23_amountPage = k23_iPerson / k23_iPages; // 전체인원을 페이지로 나눈값 = 6

		InputData inData = new InputData(k23_iPerson, k23_amountPage, k23_iPages); // 클래스 호출

		int countAll = 0; // 전체 학생수 체크하는 변수
		if (k23_iPerson != 0) {
			for (int k23_pageNum = 0; k23_pageNum <= k23_amountPage; k23_pageNum++) { // 반복문 ..6장 인쇄하면 20명 잘린다 그래서 <=으로
																						// 처리

				inData.printHeader(k23_pageNum);
				for (int k23_i = k23_iPages * k23_pageNum; k23_i < k23_iPages * (k23_pageNum + 1); k23_i++) {
					String k23_name = String.format("안재%03d", k23_i + 1);// 001번부터 순차적 이름 생성 /%03 정수를세자리로 표현
					int k23_kor = (int) (Math.random() * 100); // 랜덤한 점수 획득
					int k23_eng = (int) (Math.random() * 100); // 랜덤한 점수 획득
					int k23_mat = (int) (Math.random() * 100); // 랜덤한 점수 획득

					if (k23_i >= k23_iPerson) { // 학생 수 만큼 반복
						break;
					}
					countAll++;// 총 학생수 체크(초기화 없이 계속 누적)
					inData.SetData(k23_i, k23_name, k23_kor, k23_eng, k23_mat);// 획득한 값들을 메소드를 활용하여 배열에 입력
				}
				for (int j = 0; j < k23_iPages; j++) { // 페이지 인원수 만큼 돌아가는 반복문
					System.out.printf("%03d%7s %7d%9d%9d%9d%9.2f\n", (j + 1) + k23_iPages * k23_pageNum,
							inData.k23_name[j + k23_iPages * k23_pageNum], // 학생의 번호(1부터니까 j+1)
							inData.k23_kor[j + k23_iPages * k23_pageNum], inData.k23_eng[j + k23_iPages * k23_pageNum],
							inData.k23_mat[j + k23_iPages * k23_pageNum], // 학생의 이름,점수,합계,평균을 배열에서 꺼내옴
							inData.k23_sum[j + k23_iPages * k23_pageNum], inData.k23_avg[j + k23_iPages * k23_pageNum]);
					if ((j + k23_iPages * k23_pageNum) >= k23_iPerson - 1) {// 200번학생의 정보는 배열199번에 들어있으므로 j값이 199보다 커지면
																			// 반복 멈춤
						break;
					}
				}
				inData.Result(k23_pageNum, countAll); // 현재 페이지와,현재까지 누적된 학생수를 변수로 결과값 출력
			}
		} else {
			System.out.println("No student");
		}
	}
}
