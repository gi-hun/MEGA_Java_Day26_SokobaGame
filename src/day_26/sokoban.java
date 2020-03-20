//���ڹ� ���
//1) ���� 4�� ��� 1�� �� 1�� �������� �ڸ��� �����ȴ�
//2) ĳ���� �����Ӱ� �����δ�
//3) ĳ���Ϳ� ���� ������ ĳ���Ͱ� �����̴� �������� ���� ���� �����δ�
//4) ĳ���Ϳ� ���� ��븦 ������ ������ ����ȴ�
//5) ���� �ܰ��ʿ� �������� ��ġ�Ѵ� ���� ���Ҵ� -> ���� �ܰ��� ��ġ�ϸ� ���� ��, �Ʒ� �Ǵ� ��, �� �θ� ������ �� �ֱ� �����̴�
//6) ���� ���� �ѷ��ο� �ִ� ���� ������ �ٽ� �����ؾ� �Ѵ�

package day_26;

import java.util.Scanner;
import java.util.Random;

public class sokoban {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int game[][] = new int[7][7];
		int wall_count = 0;		int ball_count = 0;		int goalpoast_count = 0;
		int player_x = 0;		int player_y = 0;
		int ball_x = 0;			int ball_y = 0;
		int poast_x = 0;		int poast_y = 0;
		
		while(wall_count < 4)
		{
			int wall1 = ran.nextInt(7);
			int wall2 = ran.nextInt(7);
			
			if(game[wall1][wall2] == 0)
			{
				game[wall1][wall2] = 6;
				wall_count++;
			}
		}
		
		while(ball_count < 1)
		{
			int ball1 = ran.nextInt(5)+1;
			int ball2 = ran.nextInt(5)+1;
			
			if(game[ball1][ball2] == 0)
			{
				game[ball1][ball2] = 7;
				ball_count++;
			}
		}
		
		while(goalpoast_count < 1)
		{
			int goalpoast1 = ran.nextInt(7);
			int goalpoast2 = ran.nextInt(7);
			
			if(game[goalpoast1][goalpoast2] == 0)
			{
				game[goalpoast1][goalpoast2] = 8;
				goalpoast_count++;
			}
		}
		
		System.out.println("        ====SOKOBAN====");				//show Bingo Board
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 7; j++) 
			{	
				if(game[i][j] == 6)
				{
					System.out.print("[�� ] ");
				}
				else if(game[i][j] == 7)
				{
					System.out.print("[�� ] ");
				}
				else if(game[i][j] == 8)
				{
					System.out.print("[�� ] ");
				}
				else if(game[i][j] == 9)
				{
					System.out.print("[W ] ");
				}
				else
				{
					System.out.print("["+game[i][j] + " ] ");
				}
			}
			System.out.println();
		}
		
		System.out.println("���� ����!");
		System.out.println("ĳ������ ���� ��ġ�� �Է����ּ���");
		System.out.println("ĳ������ x��ǥ");
		int p1x = sc.nextInt();
		System.out.println("ĳ������ y��ǥ");
		int p1y = sc.nextInt();
		
		if(game[p1y][p1x] == 0)				//ĳ���� �����̰� �ϴ� if��
		{
			game[p1y][p1x] = 9;
			player_x = p1x;
			player_y = p1y;
		}
		
		while(true)
		{	
			int check = 0;
			
			System.out.println("        ====SOKOBAN====");				//show Bingo Board
			for (int i = 0; i < 7; i++) 
			{
				for (int j = 0; j < 7; j++) 
				{	
					if(game[i][j] == 6)
					{
						System.out.print("[�� ] ");
					}
					else if(game[i][j] == 7)
					{
						System.out.print("[�� ] ");
						ball_x = j;
						ball_y = i;
					}
					else if(game[i][j] == 8)
					{
						System.out.print("[�� ] ");
						poast_x = j;
						poast_y = i;
					}
					else if(game[i][j] == 9)
					{
						System.out.print("[W ] ");
					}
					else if(game[i][j] == 0)
					{
						System.out.print("["+game[i][j] + " ] ");
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]�� [2]�� [3]�� [4]��");
			int dir = sc.nextInt();
			
			if(dir == 1) {					//��
				if(ball_y-1 == poast_y && ball_x == poast_x)
				{
					System.out.println("���� ��뿡 �����̽��ϴ�.");
					System.out.println("������ �����մϴ�.");
					break;
				}
				
				if(player_y == 0)
				{
					game[0][player_x] = game[0][player_x];
					check = 1;
				}
				else
				{	
					if(game[player_y-1][player_x] == 6)
					{
						System.out.println("���� ���� �������� �����ϴ�.");
					}
					else
					{
						if(game[player_y-1][player_x] == 7)			//W������ ���� ���� ��
						{
							if(ball_y==0)
							{
						    	game[0][ball_x] = game[0][ball_x];
						    	game[1][player_x] = game[1][player_x];
						    	check = 1;
							}
							else if(game[ball_y-1][ball_x] == 6 && ball_y != 0)
							{
								System.out.println("���� ���� ������ �� �����ϴ�. ");
							}
							else
							{
								game[ball_y-1][ball_x] = 7;
								game[ball_y][ball_x] = 0;
								ball_y = ball_y-1;
								
								game[player_y-1][player_x] = 9;
								game[player_y][player_x] = 0;
								player_y = player_y-1;
							}
						}
						else
						{
							game[player_y-1][player_x] = 9;				//W������ �ƹ��͵� ������
							game[player_y][player_x] = 0;
							player_y = player_y-1;
						}
					}
					
				}
				
				if(check == 1)
				{
					System.out.println("�� �̻� �Է��Ͻ� �������� �������� ���մϴ�.");
				}
			}
			
			else if(dir == 2) {					//��
				if(ball_y+1 == poast_y && ball_x == poast_x)
				{
					System.out.println("���� ��뿡 �����̽��ϴ�.");
					System.out.println("������ �����մϴ�.");
					break;
				}
				if(player_y == 6)
				{
					game[6][player_x] = game[6][player_x];
					check = 1;
				}
				else
				{
					if(game[player_y+1][player_x] == 6)
					{
						System.out.println("���� ���� �������� �����ϴ�.");
					}
					else
					{
						if(game[player_y+1][player_x] == 7)
						{
							if(ball_y==6)
							{
								game[6][ball_x] = game[6][ball_x];
								game[5][player_x] = game[5][player_x];
								check = 1;
							}
							else if(game[ball_y+1][ball_x] == 6 && ball_y != 6)
							{
								System.out.println("���� ���� ������ �� �����ϴ�. ");
							}
							else
							{
								game[ball_y+1][ball_x] = 7;
								game[ball_y][ball_x] = 0;
								ball_y = ball_y+1;
								
								game[player_y+1][player_x] = 9;
								game[player_y][player_x] = 0;
								player_y = player_y+1;
							}
						}
						else
						{
							game[player_y+1][player_x] = 9;
							game[player_y][player_x] = 0;
							player_y = player_y+1;
						}
					}
				}
				
				if(check == 1)
				{
					System.out.println("[��]�� �����ϼ� �����ϴ�.");
				}
			}
			else if(dir == 3) {					//��
				if(ball_y == poast_y && ball_x-1 == poast_x)
				{
					System.out.println("���� ��뿡 �����̽��ϴ�.");
					System.out.println("������ �����մϴ�.");
					break;
				}
				if(player_x == 0)
				{
					game[player_y][0] = game[player_y][0];
					check = 1;
				}
				else
				{
					if(game[player_y][player_x-1] == 6)
					{
						System.out.println("���� ���� �������� �����ϴ�.");
					}
					else
					{
						if(game[player_y][player_x-1] == 7)
						{
							if(ball_x==0)
							{
								game[ball_y][0] = game[ball_y][0];
								game[ball_y][1] = game[ball_y][1];
								check = 1;
							}
							else if(game[ball_y][ball_x-1] == 6 && ball_x != 0)
							{
								System.out.println("���� ���� ������ �� �����ϴ�. ");
							}
							else
							{
								game[ball_y][ball_x-1] = 7;
								game[ball_y][ball_x] = 0;
								ball_x = ball_x-1;
								
								game[player_y][player_x-1] = 9;
								game[player_y][player_x] = 0;
								player_x = player_x-1;
							}
						}
						else
						{
							game[player_y][player_x-1] = 9;
							game[player_y][player_x] = 0;
							player_x = player_x-1;
						}
					}
				}
				
				if(check == 1)
				{
					System.out.println("[��]�� �����ϼ� �����ϴ�.");
				}
			}
			else if(dir == 4) {					//��
				if(ball_y == poast_y && ball_x+1 == poast_x)
				{
					System.out.println("���� ��뿡 �����̽��ϴ�.");
					System.out.println("������ �����մϴ�.");
					break;
				}
				if(player_x == 6)
				{
					game[player_y][6] = game[player_y][6];
					check = 1;
				}
				else
				{
					if(game[player_y][player_x+1] == 6)
					{
						System.out.println("���� ���� �������� �����ϴ�.");
					}
					else
					{
						if(game[player_y][player_x+1] == 7)
						{
							if(ball_x==6)
							{
								game[ball_y][6] = game[ball_y][6];
								game[player_y][5] = game[player_y][5]; 
								check = 1;
							}
							else if(game[ball_y][ball_x-1] == 6 && ball_x != 6)
							{
								System.out.println("���� ���� ������ �� �����ϴ�. ");
							}
							else
							{	
								game[ball_y][ball_x+1] = 7;
								game[ball_y][ball_x] = 0;
								ball_x = ball_x+1;
								
								game[player_y][player_x+1] = 9;
								game[player_y][player_x] = 0;
								player_x = player_x+1;
							}
						}
						else
						{
							game[player_y][player_x+1] = 9;
							game[player_y][player_x] = 0;
							player_x = player_x+1;	
						}
					}
				}
				
				if(check == 1)
				{
					System.out.println("[��]�� �����ϼ� �����ϴ�.");
				}
			}
			else
			{
				System.out.println("�̵�Ű�� �߸� �Է��Ͽ����ϴ�.");
			}
			
		}//���� �ݺ� ����
		
	}
}