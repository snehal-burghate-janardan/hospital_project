package project_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import project_dao.AddressDao;
import project_dao.BranchDao;
import project_dao.EncountorDao;
import project_dao.HospitalDao;
import project_dao.MedItemsDao;
import project_dao.MedoOrdersDao;
import project_dao.PersonDao;
import project_dto.Address;
import project_dto.Branch;
import project_dto.Encountor;
import project_dto.Hospital;
import project_dto.MedItems;
import project_dto.MedoOrders;
import project_dto.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		//object for hospital
		Hospital hospital=new Hospital();
		HospitalDao hospitalDao=new HospitalDao();
		//object for branch
		Branch branch=new Branch();
		BranchDao branchDao=new BranchDao();
		//object for address
		Address address=new Address();
		AddressDao addressDao=new AddressDao();
	    //object for person
		Person person=new Person();
		PersonDao personDao=new PersonDao();
		//object for encountor
		Encountor encountor=new Encountor();
		EncountorDao encountorDao=new EncountorDao();
		//object for MedoOrder
		MedoOrders medoOrders=new MedoOrders();
		MedoOrdersDao medoOrdersDao=new MedoOrdersDao();
		//object 
		MedItems medItems=new MedItems();
		MedItemsDao medItemsDao=new MedItemsDao();
		
		
		
		boolean flag=true;
		
		do {
		
			System.out.println("\n 1.for Hospital details \n 2.for Branch details \n 3.Address details \n 4.Person details \n 5.Encountor details \n 6.for MedoOrderDetails \n 7.MedItems Details \n 8.for exist ");
		    System.out.println("Enter your Choice");
		    int choice=s.nextInt();
		    
		    switch (choice) {
		    
			case 1:
				boolean flag1=true;
				do {
					System.out.println("\n 1.for Save hospital \n 2. for Update hospital \n 3. for Delete hospital \n 4.fecth the hospital details \n 5. for all hospital details \n 6.for exsit");
				    System.out.println("Enter your Choice");
				    int choice1=s.nextInt();
				    
				    switch (choice1) {
					case 1:{
						System.out.println("Enter hospital name");
						String hopsn=s.next();
						System.out.println("Enter gst no");
						String gst=s.next();
						

						hospital.setHospname(hopsn);
						hospital.setGst(gst);
						
						
						hospitalDao.saveHospital(hospital);
					}
					break;
					case 2:{
						System.out.println("Enter hospital id for update");
						int h_id=s.nextInt();
						System.out.println("Enter hospital name");
						String name=s.next();
						
						hospital.setH_id(h_id);
						hospital.setHospname(name);
						
						hospitalDao.updateHospital(h_id, name);
					}
					break;
					case 3:{
						System.out.println("Enter hospital id for delete");
						int h_id=s.nextInt();
						
						hospital.setH_id(h_id);
						hospitalDao.deleteHospital(h_id);
						
					}
					break;
					case 4:{
						System.out.println("fetch hospital details by hospital id");
						int h_id=s.nextInt();
						
						hospital.setH_id(h_id);
						hospitalDao.getHospital(h_id);
					}
					case 5:{
						System.out.println(hospitalDao.getAllHospital());
						
					}
					break;
					case 6:{
						flag1=false;
					}

					default:
						break;
					}
				
			} while (flag1);
				
		     case 2 : {
		    	 boolean flag2=true;

                 do {
                    System.out.println("Select Your Choice ");
                    System.out.println("\n 1.For save  Branch  \n 2.For to update Branch \n 3 .For delete Branch \n 4.For fetch Branch by Id \n 5.To get All Branch \n  6 . To Exit");
                    int choice1=s.nextInt();

                    //start 2
                   switch(choice1) {

                                 case 1 : {
                                	 System.out.println("enter hospital_id to add_branch");
                                	 int h_id=s.nextInt();
                                	 System.out.println("Enter the name of branch");
                                	 String name=s.next();
                                	 System.out.println("Enter the address");
                                	 String add=s.next();
                                	 System.out.println("Enter the phone no");
                                	 long phone=s.nextLong();
                                	
                                	 
                                	 
                                	 branch.setBranchname(name);
                                	 branch.setBaddress(add);
                                	 branch.setPhone(phone);
                                	 
                                	 branchDao.saveBranch(h_id, branch);
                                	 System.out.println("Branch saved");
                                	 
                             }break;
                             case 2 : {
                            	 System.out.println("Enter the branch id for update");
                            	 int b_id=s.nextInt();
                            	 System.out.println("Brnch name for update");
                            	 String name=s.next();
                            	 
                            	 branch.setB_id(b_id);
                            	 branch.setBranchname(name);
                            	 
                            	 branchDao.updateBranch(b_id, name);
                            	 System.out.println("Branch updated");
                              }break;
                             case 3 : {
                            	 System.out.println("Enter the branch id for delete");
                            	 int b_id=s.nextInt();
                            	 
                            	 branch.setB_id(b_id);
                            	 branchDao.deleteBranch(b_id);
                              }break;
                              case 4 : {
                                 System.out.println("fetch branch details by branch id");
                                 int b_id=s.nextInt();  
                                 branch.setB_id(b_id);
                                 branchDao.getBranch(b_id);
                             }break;
                             case 5 : {
                                    System.out.println(branchDao.getAllBranchs());
                             }break;
                             case 6 :{
                            	 flag2=false;

                                 }break;
                             default:
         					 break;

                              }//end 2
                }while(flag2);
		     }
		     break;
		     case 3 : {
                      boolean flag2=true;
                      do {
                    	  System.out.println(" 1 . To insert Address  \n 2 . To update Address \n 3 . To delete Address \n 4 . To fetch Address by Id \n 5 . To get All Address \n 6 . To Exit");
                    	  System.out.println("Select Your Choice ");
                    	  int choice1=s.nextInt();
                    	
                    	  //start 3
                    	  switch(choice1) {
                    	  case 1 : {
                    		        System.out.println("Enter the address");
                                    String add=s.next();
                                    System.out.println("Enter the branch id for to save addres");
                                    int b_id=s.nextInt();
                                   
                                    address.setAddress(add);
                                    addressDao.saveAddress(b_id, address);
                                    System.out.println("address saved");
                                    
                              }break;
                              case 2 : {
                            	  System.out.println("Enter the address id for updated");
                            	  int a_id=s.nextInt();
                            	  System.out.println("Enter the address name");
                            	  String name=s.next();
                            	  
                            	  address.setA_id(a_id);
                            	  address.setAddress(name);
                            	  
                            	  addressDao.updateAddress(a_id, name);
                            	  }break;
                            	  case 3 : {
                            		  System.out.println("Enter the address id for delete");
                                	  int a_id=s.nextInt();
                                	  
                                	  address.setA_id(a_id);
                                	  addressDao.deleteAddress(a_id);
                            	  
                            	  }break;
                            	  case 4 : {
                            		  System.out.println("fetch the address by id");
                            		  int a_id=s.nextInt();
                            		  
                            		  address.setA_id(a_id);
                            		  addressDao.getAddress(a_id);
                            		  }break;
                            		  case 5 : {
                            			  System.out.println(addressDao.getAllAddress());
                            		  }break;

	                                  case 6 : {
	                                	  flag2=false;
	                                	  
	                                  }break;
                    	    }//end 3

	                    }while(flag2);
                      }
		              break;
		     case 4 : {
		    	 boolean flag2=true;
	               do {
	            	    System.out.println(" 1 . To insert Person  \n 2 . To update Person \n 3 . To delete Person \n 4 . To fetch Person by Id \n 5 . To get All Person \n 6 . To Exit");
	            	    System.out.println("Select Your Choice "); 
	                     int choice1=s.nextInt();
	                     //start 4

	                    switch(choice1) {
	                    case 1 : {
	                 
	                    	     System.out.println("Enter the name");
	                    	     String name=s.next();
	                    	     System.out.println("Enter the addres");
	                    	     String add=s.next();
	                    	     System.out.println("Enter the phone no");
	                    	     long phone=s.nextLong();
	                    	     
	                    	     person.setName(name);
	                    	     person.setAddress(add);
	                    	     person.setPhone(phone);
	                    	     
	                    	     personDao.savePerson(person);
	                    	     System.out.println("saved person");
	                    	    
	                    }break;
	                    case 2 : {
	                    	System.out.println("Enter the person id for update");
	                    	int p_id=s.nextInt();
	                    	System.out.println("Enter the name for update");
	                    	String name=s.next();
	                    	
	                    	person.setP_id(p_id);
	                    	person.setName(name);
	                    	
	                    	personDao.updatePerson(p_id, name);
	                    	System.out.println("updated");
	                    	
	                    }break;
	                    case 3 : {
                           System.out.println("Enter id for delete");
                           int p_id=s.nextInt();
                           person.setP_id(p_id);
                           personDao.deletePerson(p_id);
                           System.out.println("Deleted");
                       }break;
                       case 4 : {
                    	   System.out.println("Enter the person id for fetch the data");
                    	   int p_id=s.nextInt();
                           person.setP_id(p_id);
                           personDao.getPerson(p_id);
                           System.out.println("fetch the data");

                       }break;
                       case 5 : {
                    	   System.out.println(personDao.getAllperson());
                       
	                  }break;
	                  case 6 : {
	                	  flag2=false;

	                }break;
	            }//end 4
           }while(flag2);
	               
		}break;
		     case 5 : {
		    	 boolean flag2=true;
		    	 do {
		    		 System.out.println(" 1 . To insert Encounter  \n 2 . To update Encounter \n 3 . To delete Encounter \n 4 . To fetch Encounter by Id \n 5 . To get All Encounter \n 6 . To Exit");
		    		 int choice1=s.nextInt(); //start 5
                     switch(choice1) {
                     case 1 : {
                    	 System.out.println("Enter the person id for encounter");
                    	 int p_id=s.nextInt();
                    	 System.out.println("Enter the branch id person encountor");
                    	 int b_id=s.nextInt();
                    	 System.out.println("Enter the reason for encountor");
                    	 String reasonname=s.next();
                    	 
                    	 encountor.setReason(reasonname);
                    	 encountorDao.saveEncountor(p_id, b_id, encountor);
                     }break;
                     case 2 : {
                    	 System.out.println("Enter the encountor id ");
                    	 int e_id=s.nextInt();
                    	 System.out.println("Enter the branch id");
                    	 int b_id=s.nextInt();
                    	 System.out.println("Enter the reason");
                    	 String reason=s.next();
                    	 
                    	 
                         encountorDao.updateEncounter(e_id, b_id, reason);
                    	 
                  }break;
                  case 3 : {
                	     System.out.println("Enter the encountor id for delete");
                 	     int e_id=s.nextInt();
                 	     encountor.setE_id(e_id);
                 	     encountorDao.deleteEncounter(e_id);
                 	    }break;

	             case 4 : {
	            	 System.out.println("Enter encountor id to fetch the details");
	            	 int e_id=s.nextInt();
             	     encountor.setE_id(e_id);
             	     encountorDao.getEncounterById(e_id);
	             }break;
	             case 5 : {
	            	 System.out.println(encountorDao.getAllEncounters());
	            	 }break;
	             case 6 : {
	            		 flag2=false;
	            		 
	             }break;
	             
             }//end 5
           }while(flag2);
		  }break;
		     case 6 : {
		    	 boolean flag2=true;
		    	 do { 
	                 System.out.println(" 1 . To insert Med_Orders  \n 2 . To update Med_Orders \n 3 . To delete Med_Orders \n 4 . To fetch Med_Orders by Id \n 5 . To get All Med_Orders \n 6 . To Exit");
	                 int choice1=s.nextInt();
	                 //start 6
	                 switch(choice1) {
	                 case 1 : {
	                	 System.out.println("Enter the encountor id ");
	                	 int e_id=s.nextInt();
	                	 System.out.println("Enter the doctorname");
	                	 String doctorname=s.next();
	                	 
	                	medoOrders.setDoctorname(doctorname);
	                	
	                	medoOrdersDao.saveMedoOrder(e_id, medoOrders);
	                	System.out.println("Saved");
	                  }break;
	                  case 2 : {
                            System.out.println("Enter the medo order id");
                            int mdeoOrder=s.nextInt();
                            System.out.println("Enter the doctor name");
                            String doctorname=s.next();
                            
                            medoOrders.setOrder_id(mdeoOrder);
                            medoOrders.setDoctorname(doctorname);
                            
                            medoOrdersDao.updateMedoOrder(mdeoOrder, doctorname);
	                      }break;
	                      case 3 : {
	                    	  System.out.println("Enter the medo order id");
	                            int mdeoOrder=s.nextInt();
	                            medoOrders.setOrder_id(mdeoOrder);
	                            
	                            medoOrdersDao.deleteMedOrder(mdeoOrder);
	                            System.out.println("deleted");
	                          }break;
	                          case 4 : {

	                        	  System.out.println("Enter the medo order id to fetch the details");
		                          int mdeoOrder=s.nextInt();                                                
		                          medoOrders.setOrder_id(mdeoOrder);
		                          medoOrdersDao.getMedOrder(mdeoOrder);
	                           }break;
	                           case 5 : {
	                        	   System.out.println(medoOrdersDao.getAllMedorders());

	                          }break;

	                         case 6 : {
	                        	 flag2=false;
	                        	 }break;
                            }//end 6
	                 }while(flag2);
		    	 }break;
		     case 7 : {
		    	 boolean flag2=true;
		    	 do {
		    		
                     System.out.println(" 1 . To insert Med_Items  \n 2 . To update Med_Items \n 3 . To delete Med_Items \n 4 . To fetch Med_Items by Id \n 5 . To get All Med_Items \n 6 . To Exit");
                     System.out.println("Select Your Choice ");
	                  int choice1=s.nextInt();
	                  //start 7

	                 switch(choice1) {
	                 case 1 : {
	                	 System.out.println("Enter the medItems name");
	                	 String m_name=s.next();
	                	 System.out.println("enter the medItems price");
	                	 double price=s.nextDouble();
	                	 System.out.println("enetr the medorder id");
	                	 int medoOrderid=s.nextInt();
	                	 
	                	 medItems.setMedItem_name(m_name);
	                	 medItems.setMedItem_price(price);
	                	 
	                	 medItemsDao.saveMedItems(medoOrderid, medItems);
	                	 System.out.println("Saved");
	              }break;
	              case 2 : {
	            	  System.out.println("enter the medoItems id");
	            	  int medoItemid=s.nextInt();
	            	  System.out.println("Enter the medoItems name for update");
	            	  String medoitemsname=s.next();
	            	  
	            	  medItems.setMedItem_id(medoItemid);
	            	  medItems.setMedItem_name(medoitemsname);
	            	  
	            	  medItemsDao.updateMedItems(medoItemid, medoitemsname);
	            	  System.out.println("updated");
	              }break;
	              case 3 : {
	            	  System.out.println("enter the medoItems id for deleted");
	            	  int medoItemid=s.nextInt();
	            	  medItems.setMedItem_id(medoItemid);
	            	  
	            	  medItemsDao.deleteMedItems(medoItemid);
	                }break;
	                case 4 : {
	                	 System.out.println("enter the medoItems id to fetch the details");
		            	  int medoItemid=s.nextInt();
		            	  medItems.setMedItem_id(medoItemid);
		            	  medItemsDao.getMedItems(medoItemid);
	                   }break;

	               case 5 : {
                       System.out.println(medItemsDao.getALlMedItems());
	                   }break;

	                                                               

	                case 6 : {

	                         flag2=false;

	               }break;

	           }//end 7

	  }while(flag2);

 }break;

	                 case 8 : {
	                	 flag1=false;
	                	 System.out.println(" Thank You visiting again");
	                	 }break;

	             }// End of Switch case

	       }while(flag);
		}

	 

	}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				



