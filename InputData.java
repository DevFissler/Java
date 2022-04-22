package p41;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InputData {

	public static int[] k23_num, k23_kor, k23_eng, k23_mat, k23_sum; // ��ȣ ���� �� �� ������ �迭 ����
	public static float[] k23_avg; //����� �� �Ǽ��� �迭 ����
	public static String[] k23_name; // �̸��� �� ������ �迭 ����
	public static int k23_iPerson, k23_iPages, k23_iPageNum; // �������� ����� ���� ����
	
	public InputData(int k23_iPerson, int k23_iPageNum, int k23_iPages) { //Ŭ���� ������ ����� �迭 ����
				
		this.k23_iPages = k23_iPages; //�������� ����� �ο�
		this.k23_iPerson = k23_iPerson;// //�� �ο�
		
		k23_num = new int [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_kor = new int [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_eng = new int [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_mat = new int [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_sum = new int [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_avg = new float [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		k23_name = new String [k23_iPerson]; //�迭 ũ�� �� �ο����� ����
		
	}
	
	public void printHeader(int k23_iPageNum) { //��� �κ� �μ�(������ ��������ȣ)
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //������� ���� ����
		String k23_date = sdf.format(new Date());// Date�� ����ð� �޾ƿͼ� ���Ŀ� ����
		System.out.printf("%30s\n","��������ǥ");
		System.out.printf("%s%d%26s%10s\n","PAGE:", k23_iPageNum+1, "�������: ", k23_date); //page��ȣ�� 1���� ��  +1����� ����
		System.out.printf("========================================================\n");
		System.out.printf("%s%6s%6s%7s%7s%7s%7s\n","��ȣ","�̸�","����","����","����","����","���");
		System.out.printf("========================================================\n");
			
	}
	
	public void SetData (int k23_i, String k23_name, int k23_kor, int k23_eng, int k23_mat ) { // �迭�� ���� �ִ� �޼ҵ�
		
		this.k23_num[k23_i] = k23_i+1; //1������ 200������
		this.k23_name[k23_i] = k23_name;//�迭�� ù��°��  0���̹Ƿ� 
		this.k23_kor[k23_i] = k23_kor;//�迭�� ù��°��  0���̹Ƿ� 
		this.k23_eng[k23_i] = k23_eng;//�迭�� ù��°��  0���̹Ƿ� 
		this.k23_mat[k23_i] = k23_mat;//�迭�� ù��°��  0���̹Ƿ� 
		k23_sum[k23_i] = k23_kor + k23_eng + k23_mat;//�� ������ ��
		k23_avg[k23_i] = k23_sum[k23_i]/3.0f;//�� ������ ���(�Ǽ������� ����ϱ����� float�� ����)
		
	}
	
	public void Result(int k23_i,int k23_countAll) { // ��� ��� �޼ҵ� (�� ������ ���� �� ��ü �ο����� ������ ����)
		
		int k23_countPage = 0; //�������� �ο��� ���� ����(20���� ��쵵 �����Ƿ�..�������� ���� �ʱ�ȭ)
		int k23_korPageSum = 0; //�������� �������� ��
		int k23_engPageSum = 0; //�������� �������� ��
		int k23_matPageSum = 0; //�������� �������� ��
		int k23_sumPageSum = 0; //�������� ���� ��
		float k23_avgPageSum = 0;//�������� ��� 
		int k23_korAccuSum = 0; //���� ��������
		int k23_engAccuSum = 0; //���� ��������
		int k23_matAccuSum = 0; //���� ��������
		int k23_sumAccuSum = 0; //���� ���� ��
		float k23_avgAccuSum = 0; //���� ���

		for (int k23_j = k23_iPages * k23_i; k23_j < k23_iPages *(k23_i+1); k23_j++) { //0~29 / 30~59 ...

			k23_korPageSum += k23_kor[k23_j]; // �� �л��� ���������� �������� �������� �տ� ����
			k23_engPageSum += k23_eng[k23_j]; // �� �л��� ���������� �������� �������� �տ� ����
			k23_matPageSum += k23_mat[k23_j]; // �� �л��� ���������� �������� �������� �տ� ����
			k23_sumPageSum += k23_sum[k23_j]; // �� �л��� �����հ踦 �������� ���� �տ� ����
			k23_avgPageSum += k23_avg[k23_j]; // �� �л��� ��������� �������� ��� ��  ����
			k23_countPage++; //�������� �л��� ������� üũ
			if (k23_j >= k23_iPerson-1) { //0���� ������ j�� 199�� 200�� ���Ҵٴ� �� 
				break; // �ݺ� ����
			}
			
		}

		for (int k23_k = 0; k23_k < k23_iPages * (k23_i + 1); k23_k++) {

			k23_korAccuSum += k23_kor[k23_k]; // �� �л��� ���������� ���� �������� �տ� ����
			k23_engAccuSum += k23_eng[k23_k]; // �� �л��� ���������� ���� �������� �տ� ����
			k23_matAccuSum += k23_mat[k23_k]; // �� �л��� ���������� ���� �������� �տ� ����
			k23_sumAccuSum += k23_sum[k23_k]; // �� �л��� �����հ踦 ���� ���� �տ� ����
			k23_avgAccuSum += k23_avg[k23_k]; // �� �л��� ��������� ���� ��� ��  ����
			if (k23_k >= k23_iPerson-1) { //0���� ������ k�� 199�� 200�� ���Ҵٴ� ��
				break; //�ݺ� ����
			}

		}
		System.out.printf("========================================================\n");
		System.out.println("���� ������");
		System.out.printf("%s%16d%9d%9d%9d%9.2f\n", "�հ�", k23_korPageSum, k23_engPageSum, k23_matPageSum, k23_sumPageSum, k23_avgPageSum); //���������� �հ� 
		System.out.printf("%s%16.2f%9.2f%9.2f%9.2f%9.2f\n", "���", (float)k23_korPageSum / k23_countPage, (float)k23_engPageSum / k23_countPage, //������ �� ���� ���� ������ �� �л����� ����
				(float)k23_matPageSum / k23_countPage, (float)k23_sumPageSum / k23_countPage, (float)k23_avgPageSum / k23_countPage); //�Ҽ��� ǥ���ϱ����� (float)ó����
		System.out.printf("========================================================\n");
		System.out.println("���� ������");
		System.out.printf("%s%16d%9d%9d%9d%9.2f\n", "�հ�", k23_korAccuSum, k23_engAccuSum, k23_matAccuSum, k23_sumAccuSum, k23_avgAccuSum); //���� ������ �հ�
		System.out.printf("%s%16.2f%9.2f%9.2f%9.2f%9.2f\n\n\n", "���", (float)k23_korAccuSum / k23_countAll, (float)k23_engAccuSum / k23_countAll, // ���� ���� ���� ���� �л����� ����
				(float)k23_matAccuSum / k23_countAll, (float)k23_sumAccuSum / k23_countAll, (float)k23_avgAccuSum / k23_countAll); //�Ҽ��� ǥ���ϱ����� (float)ó����
		

	}
}
