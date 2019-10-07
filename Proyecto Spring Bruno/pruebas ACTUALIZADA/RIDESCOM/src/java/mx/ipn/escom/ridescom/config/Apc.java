///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mx.ipn.escom.ridescom.config;
//
//import java.io.IOException;
//import mx.ipn.escom.ridescom.config.Craw;
///**
// *
// * @author spy51
// */
//public class Apc {
//    public String apc() throws IOException{
//        Craw crw=new Craw();
//        String nombre=crw.nombre();
//        String comp="DEL";
//		String comp1="DE";
//		String comp2="LA";
//		String comp3="LOS";
//		String comp4="Y";
//		String comp5="DOS";
//		String comp6 ="A";
//		String comp7 ="LAS";
//		
//		String [] completo = nombre.split(" ");
////		String [] completo1 =nombre.split("  ");
//		
//		switch (completo.length) {
//			
//			case 2://Caso para Nombre y 1 apellido.
//				
//				String n = completo[0];
//		    	String a = completo[1];
//		    	
//		    	System.out.println("Apellido Paterno: "+a);
//		        System.out.println("Nombre: " +n);
//			break;
//				
//			case 3: //Caso para nombre, ap paterno, ap materno / nombre y 1 apellido compuesto (Caso 2)
//				
//				String n1 = completo[0];
//		    	String a1 = completo[1];
//		    	String a2 = completo[2];
//		    	
//		    	if(a1.compareTo(comp)==0||a1.compareTo(comp1)==0||a1.compareTo(comp2)==0||a1.compareTo(comp3)==0||a1.compareTo(comp4)==0||a1.compareTo(comp5)==0||a1.compareTo(comp6)==0||a1.compareTo(comp7)==0) {
//		    		
//	/*Caso 2*/		String cp= a1.concat(" ").concat(a2);
//		    	
//		    		System.out.println("Apellido Paterno: " +cp); //Apellido Paterno Compuesto de 2
//			        System.out.println("Nombre: " +n1);
//			        
//			        
//	/*Caso 3*/	}else {
//			    	
//		    		System.out.println("Apellido Paterno: "+a1);
//		    		System.out.println("Apellido Materno: "+a2);
//			        System.out.println("Nombre: " +n1);
//		    	
//		    	}
//	        break;
//		        
//			case 4://Caso para 2 nombres y 2 apellidos // 1 nombre, 1 apellido y 1 apellido compuesto
//				
//				String na = completo[0];
//				String app = completo[1]; //Compuesto de Ap_Paterno // Nombre 2
//				String c1 = completo[2]; //Compuesto de Ap_Materno // Puede ser Ap_Paterno // Resante de Ap_Paterno 
//				String apcm = completo[3]; // Ap_Materno // Restante de Ap_Materno
//				
//				if(app.compareTo(comp)==0||app.compareTo(comp1)==0||app.compareTo(comp2)==0||app.compareTo(comp3)==0||app.compareTo(comp4)==0||app.compareTo(comp5)==0||app.compareTo(comp6)==0||app.compareTo(comp7)==0) {
//	/*Caso 2*/		if(c1.compareTo(comp)==0||c1.compareTo(comp1)==0||c1.compareTo(comp2)==0||c1.compareTo(comp3)==0||c1.compareTo(comp4)==0||c1.compareTo(comp5)==0||c1.compareTo(comp6)==0||c1.compareTo(comp7)==0) {
//						
//						String apc1=app.concat(" ").concat(c1).concat(" ").concat(apcm);
//		
//						System.out.println("Apellido Paterno: "+apc1); //Apellido Paterno Compuesto de 3
//						System.out.println("Nombre: "+na);
//				
//	/*Caso 3*/		}else {
//						
//						String apc1=app.concat(" ").concat(c1);
//						
//						System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno Compuesto de 2
//						System.out.println("Apellido Materno: "+apcm);
//						System.out.println("Nombre: "+na);
//					}
//	/*Caso 3*/	}else if(c1.compareTo(comp)==0||c1.compareTo(comp1)==0||c1.compareTo(comp2)==0||c1.compareTo(comp3)==0||c1.compareTo(comp4)==0||c1.compareTo(comp5)==0||c1.compareTo(comp6)==0||c1.compareTo(comp7)==0) {
//						
//					String apc1= c1.concat(" ").concat(apcm);
//					
//					System.out.println("Apellido Paterno: "+app);
//					System.out.println("Apellido Materno: "+apc1); //Apellido Materno Compuesto de 2
//					System.out.println("Nombre: "+na);
//					
//	/*Caso 4*/	}else {
//
//			    	String names = na.concat(" ").concat(app);
//			    	
//			    	System.out.println("Apellido Paterno: "+c1); // Apellido Paterno
//			        System.out.println("Apellido Materno: "+apcm); // Apellido Materno
//			        System.out.println("Nombres: " +names); //2 Nombres
//				}
//			break;
//				
//			case 5://Caso para 3 Nombres, 1 Apellido Paterno y 1 Apellido Materno // 2 Nombres, Ap_Paterno compuesto y Ap_Materno // 1 Nombre Ap_Paterno compuesto y Ap_Materno
//				
//				String nam = completo[0]; 
//				String nam1 = completo[1]; //Posible compuesto // Nombre 2
//				String ap = completo[2]; //Posible compuesto // Nombre 3
//				String am = completo[3]; //Posible compuesto /Posible Apellido paterno
//				String am1 = completo[4];
//				
//	/*Caso 4*/	if(nam1.compareTo(comp)==0||nam1.compareTo(comp1)==0||nam1.compareTo(comp2)==0||nam1.compareTo(comp3)==0||nam1.compareTo(comp4)==0||nam1.compareTo(comp5)==0||nam1.compareTo(comp6)==0||nam1.compareTo(comp7)==0) {
//					if(ap.compareTo(comp)==0||ap.compareTo(comp1)==0||ap.compareTo(comp2)==0||ap.compareTo(comp3)==0||ap.compareTo(comp4)==0||ap.compareTo(comp5)==0||ap.compareTo(comp6)==0||ap.compareTo(comp7)==0) {
//	/*Caso 2*/			if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){
//
//							String cp1=nam1.concat(" ").concat(ap).concat(" ").concat(am).concat(" ").concat(am1);
//
//							System.out.println("Apellido Paterno: "+cp1); // Apellido Paterno compuesto de 4
//							System.out.println("Nombre: " +nam); // Nombres
//
//						}else {
//
//							String cp1 =nam1.concat(" ").concat(ap).concat(" ").concat(am);
//
//							System.out.println("Apellido Paterno: "+cp1); // Apellido Paterno compuesto de 3
//							System.out.println("Apellido Materno: "+am1); // Apellido Materno
//							System.out.println("Nombre: " +nam); // Nombres
//						}
//	/*Caso 4*/		}else if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){
//					
//						String cp1 =nam1.concat(" ").concat(ap);
//						String cp2=am.concat(" ").concat(am1);
//						
//						System.out.println("Apellido Paterno: "+cp1); // Apellido Paterno compuesto de 2
//						System.out.println("Apellido Materno: "+cp2); // Apellido Materno compuesto de 2
//						System.out.println("Nombre: " +nam); // Nombre
//						
//	/*Caso 4*/		}else {
//						String cp1 = ap.concat(" ").concat(am);
//						String nams = nam.concat(" ").concat(nam1);
//						
//						System.out.println("Apellido Paterno: " +cp1);//Apellido Paterno compuesto de 2
//						System.out.println("Apellido Materno: " +am1);//Apellido Materno
//						System.out.println("Nombres: " +nams); //2 Nombres
//					}
//	/*Caso 5*/	}else if(ap.compareTo(comp)==0||ap.compareTo(comp1)==0||ap.compareTo(comp2)==0||ap.compareTo(comp3)==0||ap.compareTo(comp4)==0||ap.compareTo(comp5)==0||ap.compareTo(comp6)==0||ap.compareTo(comp7)==0) {
//					if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){
//
//						String cp2 =ap.concat(" ").concat(am).concat(" ").concat(am1);
//						
//						System.out.println("Apellido Paterno: "+nam1); // Apellido Paterno
//						System.out.println("Apellido Materno: "+cp2); // Apellido Materno compuesto de 3
//						System.out.println("Nombres: " +nam); // Nombre
//	/*Caso 4*/		}else {
//						String cp1 = ap.concat(" ").concat(am);
//						String nams = nam.concat(" ").concat(nam1);
//						
//						System.out.println("Apellido Paterno: " +cp1); //Apellido Paterno compuesto de 2
//						System.out.println("Apellido Materno: " +am1); //Apellido Materno
//						System.out.println("Nombres: " +nams); // 2 Nombres
//					}
//	/*Caso 4*/	}else if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0) {
//					
//					String nams=nam.concat(" ").concat(nam1);
//					String cp2=am.concat(" ").concat(am1);
//					
//					System.out.println("Apellido Paterno: " +ap);//Apellido Paterno
//					System.out.println("Apellido Materno: " +cp2);//Apellido Materno compuesto de 2
//					System.out.println("Nombres: " +nams); // 2 Nombres
//	/*Caso 5*/	}else {
//					String nams =nam.concat(" ").concat(nam1).concat(" ").concat(ap);
//					
//					System.out.println("Apellido Paterno: " +am);
//					System.out.println("Apellido Materno: " +am1);
//					System.out.println("Nombres: " +nams);
//				}
//			break;
//			
///*Caso Extremo*/case 6: //4 Nombres 2 apellidos / 2 Nombres 2 apellidos compuestos 
//
//					String name = completo[0]; 
//					String name1 = completo[1]; //Nombre #2 // Nombre #2 // Nombre #2  // Posible compuesto // 
//					String name2 = completo[2]; //Nombre #3 // Nombre #3 // Posible compuesto // Posible compuesto // 
//					String name3 = completo[3]; //Nombre #4 // Posible compuesto // Apellido Paterno // Apellido Paterno //  
//					String apa = completo[4]; //Apellido Paterno // Posible compuesto // Posible compuesto // Posible compuesto
//					String ama = completo[5]; //Apellido Materno // Apellido Materno // Apellido Materno // Apellido Materno // 
//
//					System.out.println("name: "+name);
//					System.out.println("name1: "+name1);
//					System.out.println("name2: "+name2);
//					System.out.println("name3: "+name3);
//					System.out.println("apa: "+apa);
//					System.out.println("ama: "+ama);
//					System.out.println("");
//
//	/*Caso 3*/		if(name1.compareTo(comp)==0 || name1.compareTo(comp1)==0 || name1.compareTo(comp2)==0 || name1.compareTo(comp3)==0 || name1.compareTo(comp4)==0 || name1.compareTo(comp5)==0 || name1.compareTo(comp6)==0 || name1.compareTo(comp7)==0) {
//						if(name2.compareTo(comp)==0 || name2.compareTo(comp1)==0 || name2.compareTo(comp2)==0 || name2.compareTo(comp3)==0 || name2.compareTo(comp4)==0 || name2.compareTo(comp5)==0 || name2.compareTo(comp6)==0 || name2.compareTo(comp7)==0) {
//							if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
//	/*Caso 2:extremo*/			if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//									
//									String apc1 =name1.concat(" ").concat(name2).concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
//
//									System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno compuesto de 5;
//									System.out.println("Nombre: "+name); // Nombre
//									
//								}else {
//
//								String apc1 =name1.concat(" ").concat(name2).concat(" ").concat(name3).concat(" ").concat(apa);
//
//								System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno compuesto de 4;
//								System.out.println("Apellido Materno: "+ama); // Apellido Materno
//								System.out.println("Nombre: "+name); // Nombre
//								
//								}
//								
//	/*Caso 3*/				}else {
//								
//								String apc1=name1.concat(" ").concat(name2).concat(" ").concat(name3);
//								String apc2=apa.concat(" ").concat(ama);
//								
//								System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno compuesto de 3;
//								System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 2
//								System.out.println("Nombre: "+name); // Nombre
//
//							}
//	/*Caso 3*/			}else if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
//							if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//
//								String apc1 =name1.concat(" ").concat(name2);
//								String apc2=name3.concat(" ").concat(apa).concat(" ").concat(ama);
//								
//								System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno compuesto de 2;
//								System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 3
//								System.out.println("Nombre: "+name); // Nombre
//
//							}
//						}
//						
//	/*Caso 4*/		}else if(name2.compareTo(comp)==0 || name2.compareTo(comp1)==0 || name2.compareTo(comp2)==0 || name2.compareTo(comp3)==0 || name2.compareTo(comp4)==0 || name2.compareTo(comp5)==0 || name2.compareTo(comp6)==0 || name2.compareTo(comp7)==0) {
//							if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
//								if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//
//									String apc2 =name2.concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
//
//									System.out.println("Apellido Paterno: "+name1); // Apellido Paterno
//									System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 4
//									System.out.println("Nombres: "+name); //Nombre
//
//								}else {
//
//									String apc1=name2.concat(" ").concat(name3).concat(" ").concat(apa);
//									String names=name.concat(" ").concat(name1);
//
//									System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno
//									System.out.println("Apellido Materno: "+ama); // Apellido Materno compuesto de 4
//									System.out.println("Nombres: "+names); //2 Nombres
//
//								}
//	/*Caso 4*/				}else if (apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//
//								String apc1=name2.concat(" ").concat(name3);
//								String apc2=apa.concat(" ").concat(ama);
//								String names=name.concat(" ").concat(name1);
//
//								System.out.println("Apellido Paterno: "+apc1); // Apellido Paterno compuesto de 2;
//								System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 2
//								System.out.println("Nombres: "+names); //2 Nombres
//
//							}else {
//
//								String apc2=name2.concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
//
//								System.out.println("Apellido Paterno: "+name1); // Apellido Paterno ;
//								System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 4
//								System.out.println("Nombre: "+name); // Nombre DEBE SER DE 2 
//
//							}
//							
//	/*Caso 4*/		}else if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
//						if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//							
//							String names = name.concat(" ").concat(name1);
//							String apc2=name3.concat(" ").concat(apa).concat(" ").concat(ama);
//
//							System.out.println("Apellido Paterno: "+name2); // Apellido Paterno ;
//							System.out.println("Apellido Materno: "+apc2); // Apellido Materno compuesto de 3
//							System.out.println("Nombres: "+names); // 2 Nombres
//							
//						}else {
//							
//							String names = name.concat(" ").concat(name1).concat(" ").concat(name2);
//							String apc2=name3.concat(" ").concat(apa);
//	
//							System.out.println("Apellido Paterno: "+apc2); // Apellido Paterno compuesto de 2;
//							System.out.println("Apellido Materno: "+ama); // Apellido Materno
//							System.out.println("Nombres: "+names); // 3 Nombres
//							
//						}
//					}else if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {
//						
//						String names =name.concat(" ").concat(name1).concat(" ").concat(name2);
//						String apc2 = apa.concat(" ").concat(ama);
//						
//						System.out.println("Apellido Paterno: "+name3);
//						System.out.println("Apellido Materno: "+apc2);
//						System.out.println("Nombres: "+names);
//						
//	/*Caso 6*/		}else {
//						String names =name.concat(" ").concat(name1).concat(" ").concat(name2).concat(" ").concat(name3);
//						
//						System.out.println("Apellido Paterno: "+apa);
//						System.out.println("Apellido Materno: "+ama);
//						System.out.println("Nombres: "+names);
//					}
//
//					break;
//
//				case 7:
//					
//					String nom = completo[0]; 
//					String nom1 = completo[1]; //Nombre #2 // Nombre #2 // Nombre #2  // Posible compuesto 
//					String nom2 = completo[2]; //Nombre #3 // Nombre #3 // Nombre #3 //Posible compuesto // Posible compuesto 
//					String nom3 = completo[3]; //Nombre #4 // Nombre #4 // Posible compuesto // Apellido Paterno // Apellido Paterno   
//					String nom4 = completo[4]; //Nombre #5 //Apellido Paterno // Posible compuesto // Posible compuesto // Posible compuesto
//					String apat = completo[5]; //Apellido Materno // Apellido Materno // Apellido Materno // Apellido Materno // Apellido Paterno
//					String amat=completo[6]; //Apellido Materno // Apellido Materno // Apellido Materno // Apellido Materno 
//					
//					System.out.println("nom: "+nom);
//					System.out.println("nom1: "+nom1);
//					System.out.println("nom2: "+nom2);
//					System.out.println("nom3: "+nom3);
//					System.out.println("nom4: "+nom4);
//					System.out.println("apat: "+apat);
//					System.out.println("amat: "+amat);
//					System.out.println("");
//					
//					if(nom1.compareTo(comp)==0||nom1.compareTo(comp1)==0||nom1.compareTo(comp2)==0||nom1.compareTo(comp3)==0||nom1.compareTo(comp4)==0||nom1.compareTo(comp5)==0||nom1.compareTo(comp6)==0||nom1.compareTo(comp7)==0) {
//						if(nom2.compareTo(comp)==0||nom2.compareTo(comp1)==0||nom2.compareTo(comp2)==0||nom2.compareTo(comp3)==0||nom2.compareTo(comp4)==0||nom2.compareTo(comp5)==0||nom2.compareTo(comp6)==0||nom2.compareTo(comp7)==0) {
//							if(nom3.compareTo(comp)==0||nom3.compareTo(comp1)==0||nom3.compareTo(comp2)==0||nom3.compareTo(comp3)==0||nom3.compareTo(comp4)==0||nom3.compareTo(comp5)==0||nom3.compareTo(comp6)==0||nom3.compareTo(comp7)==0) {
//								if(nom4.compareTo(comp)==0||nom4.compareTo(comp1)==0||nom4.compareTo(comp2)==0||nom4.compareTo(comp3)==0||nom4.compareTo(comp4)==0||nom4.compareTo(comp5)==0||nom4.compareTo(comp6)==0||nom4.compareTo(comp7)==0) {
//	/*Caso 2:Extremo*/				if(apat.compareTo(comp)==0||apat.compareTo(comp1)==0||apat.compareTo(comp2)==0||apat.compareTo(comp3)==0||apat.compareTo(comp4)==0||apat.compareTo(comp5)==0||apat.compareTo(comp6)==0||apat.compareTo(comp7)==0) {
//
//										String apsc= nom1.concat(" ").concat(nom2).concat(" ").concat(nom3).concat(" ").concat(nom4).concat(" ").concat(apat).concat(" ").concat(amat);
//
//										System.out.println("Apellido Paterno: "+apsc);//Apellido Paterno SUPER compuesto con 6
//										System.out.println("Nombre: "+nom);//Nombre
//
//									}else {
//
//										String apc1= nom1.concat(" ").concat(nom2).concat(" ").concat(nom3).concat(" ").concat(nom4).concat(" ").concat(apat);
//
//										System.out.println("Apellido Paterno: "+apc1);//Apellido Paterno compuesto de 5
//										System.out.println("Apellido Materno: "+amat);//Apellido Materno
//										System.out.println("Nombre: "+nom);//Nombre
//
//									}
//								}else if(apat.compareTo(comp)==0||apat.compareTo(comp1)==0||apat.compareTo(comp2)==0||apat.compareTo(comp3)==0||apat.compareTo(comp4)==0||apat.compareTo(comp5)==0||apat.compareTo(comp6)==0||apat.compareTo(comp7)==0) {
//
//									String apc1= nom1.concat(" ").concat(nom2).concat(" ").concat(nom3).concat(" ").concat(nom4);
//									String apc2= apat.concat(" ").concat(amat);
//
//									System.out.println("Apellido Paterno: "+apc1);//Apellido Paterno compuesto de 4
//									System.out.println("Apellido Materno: "+apc2);//Apellido Materno compuesto de 2
//									System.out.println("Nombre: "+nom);//Nombre
//
//								}
//							}else if(nom4.compareTo(comp)==0||nom4.compareTo(comp1)==0||nom4.compareTo(comp2)==0||nom4.compareTo(comp3)==0||nom4.compareTo(comp4)==0||nom4.compareTo(comp5)==0||nom4.compareTo(comp6)==0||nom4.compareTo(comp7)==0) {
//
//								String apc1= nom1.concat(" ").concat(nom2).concat(" ").concat(nom3);
//								String apc2= nom4.concat(" ").concat(apat).concat(" ").concat(amat);
//
//								System.out.println("Apellido Paterno: "+apc1);//Apellido Paterno compuesto de 3
//								System.out.println("Apellido Materno: "+apc2);//Apellido Materno compuesto de 3
//								System.out.println("Nombre: "+nom);//Nombre
//
//							}
//						}else if(nom3.compareTo(comp)==0||nom3.compareTo(comp1)==0||nom3.compareTo(comp2)==0||nom3.compareTo(comp3)==0||nom3.compareTo(comp4)==0||nom3.compareTo(comp5)==0||nom3.compareTo(comp6)==0||nom3.compareTo(comp7)==0) {
//
//							String apc1= nom1.concat(" ").concat(nom2);
//							String apc2= nom3.concat(" ").concat(nom4).concat(" ").concat(apat).concat(" ").concat(amat);
//
//							System.out.println("Apellido Paterno: "+apc1);//Apellido Paterno compuesto de 2
//							System.out.println("Apellido Materno: "+apc2);//Apellido Materno compuesto de 4
//							System.out.println("Nombre: "+nom);//Nombre
//
//						}else {
//
//							String apc1= nom1.concat(" ").concat(nom2);
//							String apc2= nom3.concat(" ").concat(nom4).concat(" ").concat(apat).concat(" ").concat(amat);
//
//							System.out.println("Apellido Paterno: "+apc1);//Apellido Paterno 
//							System.out.println("Apellido Materno: "+apc2);//Apellido Materno compuesto de 5
//							System.out.println("Nombre: "+nom);//Nombre
//
//						}
//					}else if(nom2.compareTo(comp)==0||nom2.compareTo(comp1)==0||nom2.compareTo(comp2)==0||nom2.compareTo(comp3)==0||nom2.compareTo(comp4)==0||nom2.compareTo(comp5)==0||nom2.compareTo(comp6)==0||nom2.compareTo(comp7)==0){
//						if(nom3.compareTo(comp)==0||nom3.compareTo(comp1)==0||nom3.compareTo(comp2)==0||nom3.compareTo(comp3)==0||nom3.compareTo(comp4)==0||nom3.compareTo(comp5)==0||nom3.compareTo(comp6)==0||nom3.compareTo(comp7)==0) {
//							if(nom4.compareTo(comp)==0||nom4.compareTo(comp1)==0||nom4.compareTo(comp2)==0||nom4.compareTo(comp3)==0||nom4.compareTo(comp4)==0||nom4.compareTo(comp5)==0||nom4.compareTo(comp6)==0||nom4.compareTo(comp7)==0) {
///*Caso 2:Extremo*/				if(apat.compareTo(comp)==0||apat.compareTo(comp1)==0||apat.compareTo(comp2)==0||apat.compareTo(comp3)==0||apat.compareTo(comp4)==0||apat.compareTo(comp5)==0||apat.compareTo(comp6)==0||apat.compareTo(comp7)==0) {
//									
//								}
//							}
//						}
//					}
//					else {
//						System.out.println("No entró nada aún");
//					}
//					
//					break;
//		}
//
//        
//	}
//    }
//}
