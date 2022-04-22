package p41;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InputData {

	public static int[] k23_num, k23_kor, k23_eng, k23_mat, k23_sum; // 번호 성적 이 들어갈 정수형 배열 선언
	public static float[] k23_avg; //평균이 들어갈 실수형 배열 선언
	public static String[] k23_name; // 이름이 들어갈 문자형 배열 선언
	public static int k23_iPerson, k23_iPages, k23_iPageNum; // 전역에서 사용할 변수 선언
	
	public InputData(int k23_iPerson, int k23_iPageNum, int k23_iPages) { //클래스 내에서 사용할 배열 설정
				
		this.k23_iPages = k23_iPages; //페이지당 출력할 인원
		this.k23_iPerson = k23_iPerson;// //총 인원
		
		k23_num = new int [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_kor = new int [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_eng = new int [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_mat = new int [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_sum = new int [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_avg = new float [k23_iPerson]; //배열 크기 총 인원수로 선언
		k23_name = new String [k23_iPerson]; //배열 크기 총 인원수로 선언
		
	}
	
	public void printHeader(int k23_iPageNum) { //헤더 부분 인쇄(변수는 페이지번호)
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //출력일자 형식 지정
		String k23_date = sdf.format(new Date());// Date로 현재시간 받아와서 형식에 대입
		System.out.printf("%30s\n","성적집계표");
		System.out.printf("%s%d%26s%10s\n","PAGE:", k23_iPageNum+1, "출력일자: ", k23_date); //page번호는 1부터 라  +1해줘야 맞음
		System.out.printf("========================================================\n");
		System.out.printf("%s%6s%6s%7s%7s%7s%7s\n","번호","이름","국어","영어","수학","총점","평균");
		System.out.printf("========================================================\n");
			
	}
	
	public void SetData (int k23_i, String k23_name, int k23_kor, int k23_eng, int k23_mat ) { // 배열에 집어 넣는 메소드
		
		this.k23_num[k23_i] = k23_i+1; //1번부터 200번까지
		this.k23_name[k23_i] = k23_name;//배열의 첫번째는  0번이므로 
		this.k23_kor[k23_i] = k23_kor;//배열의 첫번째는  0번이므로 
		this.k23_eng[k23_i] = k23_eng;//배열의 첫번째는  0번이므로 
		this.k23_mat[k23_i] = k23_mat;//배열의 첫번째는  0번이므로 
		k23_sum[k23_i] = k23_kor + k23_eng + k23_mat;//각 성적의 합
		k23_avg[k23_i] = k23_sum[k23_i]/3.0f;//각 성적의 평균(실수형으로 출력하기위해 float로 나눔)
		
	}
	
	public void Result(int k23_i,int k23_countAll) { // 결과 출력 메소드 (몇 페이지 인지 와 전체 인원수를 변수로 받음)
		
		int k23_countPage = 0; //페이지내 인원수 세는 변수(20명인 경우도 있으므로..한페이지 세고 초기화)
		int k23_korPageSum = 0; //페이지내 국어점수 합
		int k23_engPageSum = 0; //페이지내 영어점수 합
		int k23_matPageSum = 0; //페이지내 수학점수 합
		int k23_sumPageSum = 0; //페이지내 점수 합
		float k23_avgPageSum = 0;//페이지내 평균 
		int k23_korAccuSum = 0; //누적 국어점수
		int k23_engAccuSum = 0; //누적 영어점수
		int k23_matAccuSum = 0; //누적 수학점수
		int k23_sumAccuSum = 0; //누적 점수 합
		float k23_avgAccuSum = 0; //누적 평균

		for (int k23_j = k23_iPages * k23_i; k23_j < k23_iPages *(k23_i+1); k23_j++) { //0~29 / 30~59 ...

			k23_korPageSum += k23_kor[k23_j]; // 각 학생의 국어점수를 페이지내 국어점수 합에 더함
			k23_engPageSum += k23_eng[k23_j]; // 각 학생의 영어점수를 페이지내 영어점수 합에 더함
			k23_matPageSum += k23_mat[k23_j]; // 각 학생의 수학점수를 페이지내 수학점수 합에 더함
			k23_sumPageSum += k23_sum[k23_j]; // 각 학생의 점수합계를 페이지내 점수 합에 더함
			k23_avgPageSum += k23_avg[k23_j]; // 각 학생의 점수평균을 페이지내 평균 에  더함
			k23_countPage++; //페이지내 학생이 몇명인지 체크
			if (k23_j >= k23_iPerson-1) { //0부터 시작한 j가 199면 200번 돌았다는 뜻 
				break; // 반복 멈춤
			}
			
		}

		for (int k23_k = 0; k23_k < k23_iPages * (k23_i + 1); k23_k++) {

			k23_korAccuSum += k23_kor[k23_k]; // 각 학생의 국어점수를 누적 국어점수 합에 더함
			k23_engAccuSum += k23_eng[k23_k]; // 각 학생의 영어점수를 누적 영어점수 합에 더함
			k23_matAccuSum += k23_mat[k23_k]; // 각 학생의 수학점수를 누적 수학점수 합에 더함
			k23_sumAccuSum += k23_sum[k23_k]; // 각 학생의 점수합계를 누적 점수 합에 더함
			k23_avgAccuSum += k23_avg[k23_k]; // 각 학생의 점수평균을 누적 평균 에  더함
			if (k23_k >= k23_iPerson-1) { //0부터 시작한 k가 199면 200번 돌았다는 뜻
				break; //반복 멈춤
			}

		}
		System.out.printf("========================================================\n");
		System.out.println("현재 페이지");
		System.out.printf("%s%16d%9d%9d%9d%9.2f\n", "합계", k23_korPageSum, k23_engPageSum, k23_matPageSum, k23_sumPageSum, k23_avgPageSum); //현재페이지 합계 
		System.out.printf("%s%16.2f%9.2f%9.2f%9.2f%9.2f\n", "평균", (float)k23_korPageSum / k23_countPage, (float)k23_engPageSum / k23_countPage, //페이지 내 점수 합을 페이지 내 학생수로 나눔
				(float)k23_matPageSum / k23_countPage, (float)k23_sumPageSum / k23_countPage, (float)k23_avgPageSum / k23_countPage); //소수점 표현하기위해 (float)처리함
		System.out.printf("========================================================\n");
		System.out.println("누적 페이지");
		System.out.printf("%s%16d%9d%9d%9d%9.2f\n", "합계", k23_korAccuSum, k23_engAccuSum, k23_matAccuSum, k23_sumAccuSum, k23_avgAccuSum); //누적 페이지 합계
		System.out.printf("%s%16.2f%9.2f%9.2f%9.2f%9.2f\n\n\n", "평균", (float)k23_korAccuSum / k23_countAll, (float)k23_engAccuSum / k23_countAll, // 누적 점수 합을 누적 학생수로 나눔
				(float)k23_matAccuSum / k23_countAll, (float)k23_sumAccuSum / k23_countAll, (float)k23_avgAccuSum / k23_countAll); //소수점 표현하기위해 (float)처리함
		

	}
}
