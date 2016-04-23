package com.briup.home01;
import java.util.Scanner;
/**
 *����һ����ʦ��Ϣ����ϵͳ
 */
public class Tms {
	private int index=0;//ͳ�ƽ�ʦ����
	private Teacher[] teas= new Teacher[5];//�洢��ʦ��Ϣ

	public static void main(String[] args){
		
		Tms tms = new Tms();
		tms.menu();
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.print("�����빦�ܱ�ţ�");
			String option = scanner.nextLine();

			switch(option){
				case "1":

					System.out.println("����Ϊ����ѧ����Ϣ��");
					Teacher[] teas = tms.findAll();
					for(int i=0;i<teas.length;i++){
						System.out.println(teas[i]);
					}
					System.out.println("�ܹ��У�"+tms.index+"����ʦ��");//����ط�Ҫ��tms.index.����ᱨ��
					break;
				case "2":
					while(true){
					System.out.println("������Ҫ��ӵ���ʦid#name#gender#age������break������һ��");//long id,String name,String gender,int age
					String teaStr=scanner.nextLine();
					if(teaStr.equals("break")){
						break;
					}
					String[] teaArr=teaStr.split("#");//split����spilt
				    long id = Long.parseLong(teaArr[0]);
					String name = teaArr[1];
					String gender = teaArr[2];
					int age = Integer.parseInt(teaArr[3]);
				    Teacher tea = new Teacher(id,name,gender,age);
					tms.save(tea) ;
					System.out.println("��ӳɹ�");
					}
					
					break;
				case "3":
					System.out.println("������Ҫɾ������ʦid:��break������һ��Ŀ¼��");
					String idStr = scanner.nextLine();
					
					if(idStr.equals("break")){
						break;
					}
					long id = Long.parseLong(idStr);
					 Teacher tea =tms.findById(id);
					 if(tea ==null){
						System.out.println("��Ҫɾ���Ľ�ʦ�����ڣ�");
					 }
					 tms.deleteById(id);
					 System.out.println("ɾ���ɹ���");

					break;
				case "4":
					
					break;
				case "5":
					while(true){
					System.out.print("������Ҫ��ѯ����ʦid:������break������һ��Ŀ¼��");
					String idStr5=scanner.nextLine();
					if(idStr5.equals("break")){
						break;
					}
					long id5 = Long.parseLong(idStr5);
					Teacher tea5=tms.findById(id5);
					System.out.println(tea5==null?"sorry no find!":tea5);
					}
					break;
				case "exit":
					System.out.println("��ӭ�ٴ�ʹ��ϵͳ");
					System.exit(0);
					break;
				case "help":
					tms.menu();
					break;

			
			}
		}

	}
	//�˵�
	public void menu(){
		System.out.println("*******��ʦ����ϵͳ*******");
		System.out.println("***1.��ѯ���н�ʦ��Ϣ");
		System.out.println("***2.��ӽ�ʦ��Ϣ");
		System.out.println("***3.ɾ����ʦ��Ϣ");
		System.out.println("***4.�޸Ľ�ʦ��Ϣ");
		System.out.println("***5.����ѧ�Ų�ѯ��ʦ��Ϣ");
		System.out.println("***exit.�˳�ϵͳϵͳ");
		System.out.println("***help.����");
		System.out.println("***************************");

	}
	private int findIndexById(long id){
		int num=-1;
		for(int i=0;i<teas.length;i++){
			if(id==teas[i].getId()){
				num=i;
				break;
			}
		}
		return num;
	}
	//�����ʦ��Ϣ
	public void save(Teacher tea){
		if(index>teas.length){
		Teacher teasDome[] = new Teacher[index+5];
		System.arraycopy(teasDome,0,teas,0,index);
	    teas= teasDome;
		}
		 teas[index++]=tea;
	}
	//ɾ����Ϣ
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			teas[i]=teas[i+1];
		}
		teas[--index]=null;
	}
	//�޸���Ϣ
	public void update(long id){
	
	}
	//��ѯ����
	public Teacher[] findAll(){
		Teacher[] teasDemo = new Teacher[index];  
		System.arraycopy(teas,0,teasDemo,0,index);//������Ҫ��System--arraycopy����Сд
		return teasDemo;
	}
	//��ѯĳһ����ʦ��Ϣ
	public Teacher findById(long id){
		int num=findIndexById(id);
		return num ==-1?null:teas[num] ;
	}
}