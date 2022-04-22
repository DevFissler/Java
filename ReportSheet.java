package p41;

public class ReportSheet {

	public static void main(String[] args) {

		int k23_iPerson = 1; // ��ü �ο��� 200
		int k23_iPages = 6; // �� �������� ����� �ο� 30
		int k23_amountPage = k23_iPerson / k23_iPages; // ��ü�ο��� �������� ������ = 6

		InputData inData = new InputData(k23_iPerson, k23_amountPage, k23_iPages); // Ŭ���� ȣ��

		int countAll = 0; // ��ü �л��� üũ�ϴ� ����
		if (k23_iPerson != 0) {
			for (int k23_pageNum = 0; k23_pageNum <= k23_amountPage; k23_pageNum++) { // �ݺ��� ..6�� �μ��ϸ� 20�� �߸��� �׷��� <=����
																						// ó��

				inData.printHeader(k23_pageNum);
				for (int k23_i = k23_iPages * k23_pageNum; k23_i < k23_iPages * (k23_pageNum + 1); k23_i++) {
					String k23_name = String.format("����%03d", k23_i + 1);// 001������ ������ �̸� ���� /%03 ���������ڸ��� ǥ��
					int k23_kor = (int) (Math.random() * 100); // ������ ���� ȹ��
					int k23_eng = (int) (Math.random() * 100); // ������ ���� ȹ��
					int k23_mat = (int) (Math.random() * 100); // ������ ���� ȹ��

					if (k23_i >= k23_iPerson) { // �л� �� ��ŭ �ݺ�
						break;
					}
					countAll++;// �� �л��� üũ(�ʱ�ȭ ���� ��� ����)
					inData.SetData(k23_i, k23_name, k23_kor, k23_eng, k23_mat);// ȹ���� ������ �޼ҵ带 Ȱ���Ͽ� �迭�� �Է�
				}
				for (int j = 0; j < k23_iPages; j++) { // ������ �ο��� ��ŭ ���ư��� �ݺ���
					System.out.printf("%03d%7s %7d%9d%9d%9d%9.2f\n", (j + 1) + k23_iPages * k23_pageNum,
							inData.k23_name[j + k23_iPages * k23_pageNum], // �л��� ��ȣ(1���ʹϱ� j+1)
							inData.k23_kor[j + k23_iPages * k23_pageNum], inData.k23_eng[j + k23_iPages * k23_pageNum],
							inData.k23_mat[j + k23_iPages * k23_pageNum], // �л��� �̸�,����,�հ�,����� �迭���� ������
							inData.k23_sum[j + k23_iPages * k23_pageNum], inData.k23_avg[j + k23_iPages * k23_pageNum]);
					if ((j + k23_iPages * k23_pageNum) >= k23_iPerson - 1) {// 200���л��� ������ �迭199���� ��������Ƿ� j���� 199���� Ŀ����
																			// �ݺ� ����
						break;
					}
				}
				inData.Result(k23_pageNum, countAll); // ���� ��������,������� ������ �л����� ������ ����� ���
			}
		} else {
			System.out.println("No student");
		}
	}
}
