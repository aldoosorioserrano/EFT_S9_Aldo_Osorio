package eft_s9_aldo_osorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EFT_S9_Aldo_Osorio {


	// Constantes
	static String nombreTeatro = "Teatro Moro";
	static Date anioBoleta = new Date();
	static SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	static String anioActual = getYearFormat.format(anioBoleta);

	static int valorGeneralConcierto = 20000;
	static int valorVIPConcierto = 50000;
	static int valorPlateaConcierto = 35000;

	static int valorGeneralTeatro = 5000;
	static int valorVIPTeatro = 7000;
	static int valorPlateaTeatro = 6000;

	static Scanner scanner = new Scanner(System.in);

	static List<Evento> eventos = new ArrayList();
	static List<Venta> ventas = new ArrayList();

	// Clase para grabar datos de boleta e imprimir el resultado en pantalla.
	public static class Boleta {

		private UUID idBoleta;
		int precio;
		String tipoEntrada;
		int cantidad;
		String descuentoAplicado;
		double precioFinalEntrada;
		int numeroAsiento;
		String descripcionEvento;
		boolean vigente;

		public Boleta() {
			// generamos un id único
			this.idBoleta = UUID.randomUUID();
		}

		public UUID getIdBoleta() {
			return idBoleta;
		}

		public void setIdBoleta(UUID idBoleta) {
			this.idBoleta = idBoleta;
		}

		public int getNumeroAsiento() {
			return numeroAsiento;
		}

		public void setNumeroAsiento(int numeroAsiento) {
			this.numeroAsiento = numeroAsiento;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getTipoEntrada() {
			return tipoEntrada;
		}

		public void setTipoEntrada(String tipoEntrada) {
			this.tipoEntrada = tipoEntrada;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getDescuentoAplicado() {
			return descuentoAplicado;
		}

		public void setDescuentoAplicado(String descuentoAplicado) {
			this.descuentoAplicado = descuentoAplicado;
		}

		public double getPrecioFinalEntrada() {
			return precioFinalEntrada;
		}

		public void setPrecioFinalEntrada(double precioFinalEntrada) {
			this.precioFinalEntrada = precioFinalEntrada;
		}

		public String getDescripcionEvento() {
			return descripcionEvento;
		}

		public void setDescripcionEvento(String descripcionEvento) {
			this.descripcionEvento = descripcionEvento;
		}

		public boolean isVigente() {
			return vigente;
		}

		public void setVigente(boolean vigente) {
			this.vigente = vigente;
		}

	};

	// CLASE VENTA

	public static class Venta {

		UUID idVenta;
		UUID idBoleta;
		int idAsiento;
		String tipoAsiento;

		public Venta() {
			// generamos un id único
			this.idVenta = UUID.randomUUID();
		}

		public int getIdAsiento() {
			return idAsiento;
		}

		public void setIdAsiento(int idAsiento) {
			this.idAsiento = idAsiento;
		}

		public UUID getIdVenta() {
			return idVenta;
		}

		public void setIdVenta(UUID idVenta) {
			this.idVenta = idVenta;
		}

		public UUID getIdBoleta() {
			return idBoleta;
		}

		public void setIdBoleta(UUID uuid) {
			this.idBoleta = uuid;
		}

		public String getTipoAsiento() {
			return tipoAsiento;
		}

		public void setTipoAsiento(String tipoAsiento) {
			this.tipoAsiento = tipoAsiento;
		}

	}


	//CLASE EVENTO
	public static class Evento {
		int idEvento;
		String descripcionEvento;

		public int getIdEvento() {
			return idEvento;
		}

		public void setIdEvento(int idEvento) {
			this.idEvento = idEvento;
		}

		public String getDescripcionEvento() {
			return descripcionEvento;
		}

		public void setDescripcionEvento(String descripcionEvento) {
			this.descripcionEvento = descripcionEvento;
		}

	}


	// CLASE ASIENTO
	public static class Asiento {

		int numeroAsiento;
		String tipoAsiento;
		boolean disponible;
		Evento idEvento;

		public int getNumeroAsiento() {
			return numeroAsiento;
		}

		public void setNumeroAsiento(int numeroAsiento) {
			this.numeroAsiento = numeroAsiento;
		}

		public String getTipoAsiento() {
			return tipoAsiento;
		}

		public void setTipoAsiento(String tipoAsiento) {
			this.tipoAsiento = tipoAsiento;
		}

		public boolean isDisponible() {
			return disponible;
		}

		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}

		public Evento getIdEvento() {
			return idEvento;
		}

		public void setIdEvento(Evento idEvento) {
			this.idEvento = idEvento;
		}

	}


	/*
	 * FUNCION PARA PODER OBTENER EL TIPO DE CLIENTE A TRAVÉS DE UN MENU.
	 */

	private static Boleta calcularPrecioEntrada(String tipoAsiento, Boleta boleta, int tipoEvento) {

		// Caoturar por pantalla el tipo Cliente
		System.out.println("****************************************\n");
		System.out.println("Tipos de clientes disponibles\n ");
		System.out.println("1 : ESTUDIANTE\n ");
		System.out.println("2 : GENERAL\n ");
		System.out.println("3 : TERCERA EDAD\n ");
		System.out.println("****************************************\n");
		System.out.println("Ingrese el tipo de cliente: ");

		int opcionTipoCliente = scanner.nextInt();

		return calcularPrecioEntradaConcierto(tipoAsiento, opcionTipoCliente, boleta, tipoEvento);

	}


	/*
	 * FUNCION PARA CALCULAR EL PRECIO DE UNA ENTRADA  DE ACUERDO AL TIPO DE ASIENTO,  TIPO DE CLIENTE
	 * Y TIPO DE EVENTO.
	 */

	private static Boleta calcularPrecioEntradaConcierto(String tipoAsiento, int opcionTipoCliente, Boleta boleta,
			int tipoEvento) {

		boleta.setTipoEntrada(tipoAsiento);
		if (tipoEvento == 1) {
			boleta.setDescripcionEvento("Concierto");
			if (opcionTipoCliente == 1) {
				boleta.setPrecio(valorGeneralConcierto);
				boleta = calcularPrecioFinal(valorGeneralConcierto, opcionTipoCliente, boleta);

			} else if (opcionTipoCliente == 2) {
				boleta.setPrecio(valorVIPConcierto);
				boleta = calcularPrecioFinal(valorVIPConcierto, opcionTipoCliente, boleta);

			} else if (opcionTipoCliente == 3) {
				boleta.setPrecio(valorPlateaConcierto);
				boleta = calcularPrecioFinal(valorPlateaConcierto, opcionTipoCliente, boleta);
			}

		} else if (tipoEvento == 2) {
			boleta.setDescripcionEvento("Teatro");
			if (opcionTipoCliente == 1) {
				boleta.setPrecio(valorGeneralTeatro);
				boleta = calcularPrecioFinal(valorGeneralTeatro, opcionTipoCliente, boleta);

			} else if (opcionTipoCliente == 2) {
				boleta.setPrecio(valorVIPTeatro);
				boleta = calcularPrecioFinal(valorVIPTeatro, opcionTipoCliente, boleta);

			} else if (opcionTipoCliente == 3) {
				boleta.setPrecio(valorPlateaTeatro);
				boleta = calcularPrecioFinal(valorPlateaTeatro, opcionTipoCliente, boleta);
			}

		}

		return boleta;
	}


	/*
	 * FUNCION PARA CALCULAR EL PRECIO DE UNA ENTRADA DE ACUERDO AL TIPO DE CLIENTE Y TIPO DE ENTRADA
	 * QUE FUE ELEGIDA PREVIAMENTE.
	 * SE AGREGA LOS DATOS DE DESCUENTO A LA BOLETA
	 */

	private static Boleta calcularPrecioFinal(int valorTipoEntrada, int opcionTipoCliente, Boleta boleta) {
		double valorFinalEntrada = 0.0;

		if (opcionTipoCliente == 1) {

			valorFinalEntrada = valorTipoEntrada * 0.90;
			boleta.setDescuentoAplicado("10%");

		} else if (opcionTipoCliente == 2) {
			boleta.setDescuentoAplicado("0%");
			valorFinalEntrada = valorTipoEntrada;

		} else if (opcionTipoCliente == 3) {
			boleta.setDescuentoAplicado("15%");
			valorFinalEntrada = valorTipoEntrada * 0.85;
		}

		System.out.println("Valor final de la entrada: " + valorFinalEntrada);
		boleta.setPrecioFinalEntrada(valorFinalEntrada);
		return boleta;
	}

	private static boolean salirPrincipal() {
		System.out.println("****************************************\n");
		System.out.println("Gracias por  asistir a  " + nombreTeatro);
		System.out.println("****************************************\n");
		System.exit(0);
		return true;
	}

	/*
	 * FUNCION PARA COMPRAR ENTRADAS
	 */
	private static Boleta comprarEntradas(int entradasDisponibles, Boleta boleta, int tipoEvento, Asiento[] asientos) {
		if (tipoEvento == 1) {

		}
		if (asientos.length == 0) {
			System.out.println("------------------------------------------\n");
			System.out.println("NO HAY ENTRADAS DISPONIBLES\n");
			System.out.println("------------------------------------------\n");
		} else if (asientos.length > 0 && asientos != null) {

			listarEntradasDisponibles(entradasDisponibles, asientos);

		}

		Venta venta = new Venta();

		int numeroAsiento = 0;

		System.out.println("------------------------------------------\n");
		System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA COMPRAR\n");
		System.out.println("------------------------------------------\n");
		// capturar por pantalla el tipo de entrada
		numeroAsiento = scanner.nextInt();
		boleta.setNumeroAsiento(numeroAsiento);

		Asiento asientoOcupado = ocuparAsiento(numeroAsiento, asientos);

		venta.setIdAsiento(numeroAsiento);
		String tipoEntrada = asientoOcupado.getTipoAsiento();

		boleta.setTipoEntrada(tipoEntrada);
		boleta = calcularPrecioEntrada(tipoEntrada, boleta, tipoEvento);

		venta.setIdBoleta(boleta.getIdBoleta());
		venta.setTipoAsiento(boleta.getTipoEntrada());
		ventas.add(venta);

		entradasDisponibles--;

		// Imprime Boleta
		System.out.println("---------------------------------------\n");
		System.out.println("---------- Boleta " + anioActual + " ----------\n");
		System.out.println("---------------------------------------\n");
		System.out.println("Evento             : " + boleta.getDescripcionEvento() + "\n");
		System.out.println("Numero Asiento     : " + boleta.getNumeroAsiento() + "\n");
		System.out.println("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
		System.out.println("Costo Base         : " + boleta.getPrecio() + "\n");
		System.out.println("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
		System.out.println("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
		System.out.println("---------------------------------------\n");
		System.out.println("Gracias por su visita al Teatro Moro\n");
		System.out.println("---------------------------------------\n");

		return boleta;
	}




	/*
	 * FUNCION PARA CAMBIAR UN ASIENTO A UN ESTADO NO DISPONIBLE.
	 */
	private static Asiento ocuparAsiento(int numeroAsiento, Asiento[] asientos) {
		Asiento asientoOcupado = new Asiento();

		for (int j = 0; j < asientos.length; j++) {
			if (asientos[j].getNumeroAsiento() == numeroAsiento) {
				asientos[j].setDisponible(false);
				asientoOcupado = asientos[j];
			}
		}
		return asientoOcupado;
	}



	/*
	 * FUNCION PARA MOSTRAR TODOS LOS ASIENTOS QUE SE ENCUENTRAN EN ESTADO DISPONIBLE.
	 */
	private static void listarEntradasDisponibles(int entradasDisponibles, Asiento[] asientos) {
		System.out.println("------------------------------------------\n");
		System.out.println("ENTRADAS DISPONIBLES\n ");
		System.out.println("------------------------------------------\n");
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i].isDisponible()) {

				System.out.println("NUMERO DE ASIENTO: " + asientos[i].getNumeroAsiento());
				System.out.println("TIPO DE ASIENTO  : " + asientos[i].getTipoAsiento());
				System.out.println("------------------------------------------\n");

			}
		}

	}


	/*
	 * FUNCION PARA CAMBIAR UN ASIENTO,EL ASIENTO ACTUAL DEBE LIBERARSE Y EL NUMERO DEJAR COMO NO DISPONIBLE.
	 */

	private static List<Boleta> modificarAsiento(Asiento[] asientos, List<Boleta> listaBoletas) {

		System.out.println("****************************************\n");
		System.out.println("Ingrese el numero de asiento que desea modificar \n");
		System.out.println("****************************************\n");
		// capturar por pantalla el tipo de entrada
		int numeroAsientoActual = scanner.nextInt();

		Venta ventaActual = null;
		for (int i = 0; i < ventas.size(); i++) {

			if (ventas.get(i).getIdAsiento() == numeroAsientoActual) {
				ventaActual = ventas.get(i);
				System.out.println("****************************************\n");
				System.out.println("DATOS ENTRADA\n");
				System.out.println("Numero asiento: " + ventas.get(i).getIdAsiento());
				System.out.println("Tipo asiento  : " + ventas.get(i).getTipoAsiento());
				System.out.println("****************************************\n");
			}

		}

		// SOLO MOSTRARA COMO OPCION DE CAMBIO ASIENTOS DEL MISMO TIPO, POR LO QUE NO SE RECALCULA EL PRECIO

		System.out.println("****************************************\n");
		System.out.println("ASIENTOS DISPONIBLES\n");
		System.out.println("****************************************\n");
		int i = 0;
		for (int j = 0; j < asientos.length; j++) {

			if (asientos[j].isDisponible() && asientos[j].getTipoAsiento().equals(ventaActual.getTipoAsiento())) {
				System.out.println("---------------------------------------\n");
				System.out.println("ASIENTO     : " + asientos[j].getNumeroAsiento() + "\n");
				System.out.println("TIPO ASIENTO: " + asientos[j].getTipoAsiento());
				System.out.println("---------------------------------------\n");
				i++;
			}
		}
		int nuevoAsiento = 0;
		if (i > 0) {
			System.out.println("****************************************\n");
			System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA  \n");
			System.out.println("****************************************\n");
			nuevoAsiento = scanner.nextInt();
		}

		ventaActual.setIdAsiento(nuevoAsiento);

		for (int j = 0; j < asientos.length; j++) {
			if (asientos[j].getNumeroAsiento() == nuevoAsiento) {
				asientos[j].setDisponible(false);
			}

		}

		System.out.println("****************************************\n");
		System.out.println("SU ASIENTO FUE MODIFICADO CORRECTAMENTE \n");
		System.out.println("****************************************\n");
		listaBoletas = modificarBoleta(numeroAsientoActual, nuevoAsiento, listaBoletas);
		return listaBoletas;

	}


	/*
	 * FUNCION PARA CAMBIAR EN LA BOLETA POR OTRO ASIENTO DEL MISMO TIPO.
	 */
	private static List<Boleta> modificarBoleta(int numeroAsientoActual, int nuevoAsiento, List<Boleta> listaBoletas) {
		for (int i = 0; i < listaBoletas.size(); i++) {
			if (listaBoletas.get(i).getNumeroAsiento() == numeroAsientoActual) {

				listaBoletas.get(i).setNumeroAsiento(nuevoAsiento);
			}
		}
		return listaBoletas;
	}



	/*
	 * FUNCION PARA LIBERAR UN ASIENTO, UN ASIENTO NO PUEDE SER ELIMINADO, SOLO LIBERADO, SIN EMBARGO
	 * LA VENTA DEBE SER ELIMINADA Y LA BOLETA CAMBIADA A NO VIGENTE.
	 */
	private static int liberarAsiento(List<Venta> ventas2, Asiento[] asientos, int entradasDisponibles,
			List<Boleta> listaBoletas) {
		System.out.println("****************************************\n");
		System.out.println("ENTRADAS VENDIDAS\n");
		System.out.println("****************************************\n");
		for (int i = 0; i < ventas2.size(); i++) {
			System.out.println("---------------------------------------\n");
			System.out.println("Asiento     : " + ventas2.get(i).getIdAsiento() + "\n");
			System.out.println("Tipo asiento: " + ventas2.get(i).getTipoAsiento());
			System.out.println("---------------------------------------\n");

		}

		System.out.println("****************************************\n");
		System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA LIBERAR ");
		System.out.println("****************************************\n");

		int numeroAsiento = scanner.nextInt();

		for (int i = 0; i < ventas2.size(); i++) {
			if (ventas2.get(i).getIdAsiento() == numeroAsiento) {
				ventas2.remove(i);
				cambiarEstadoAsiento(numeroAsiento, asientos, listaBoletas);
			}
		}
		listarEntradasDisponibles(numeroAsiento, asientos);
		return entradasDisponibles++;
	}

	/*
	 * FUNCION PARA LIBERAR UN ASIENTO, UN ASIENTO NO PUEDE SER ELIMINADO, SOLO LIBERADO.
	 */
	private static void cambiarEstadoAsiento(int numeroAsiento, Asiento[] asientos, List<Boleta> listaBoletas) {

		for (int i = 0; i < asientos.length; i++) {

			if (asientos[i].getNumeroAsiento() == numeroAsiento) {

				asientos[i].setDisponible(true);
				System.out.println("****************************************\n");
				System.out.println("EL ASIENTO HA SIDO LIBERADO ");
				System.out.println("****************************************\n");

			}
		}

		anularBoleta(numeroAsiento, listaBoletas);

	}


	/*
	 * FUNCION PARA ANULAR UNA BOLETA
	 */
	private static void anularBoleta(int numeroAsiento, List<Boleta> listaBoletas) {
		for (int i = 0; i < listaBoletas.size(); i++) {
			if(listaBoletas.get(i).getNumeroAsiento() == numeroAsiento) {
				listaBoletas.get(i).setVigente(false);
			}
		}
	}


	/*
	 * FUNCION PARA OBTENER LAS ENTRADAS VENDIDAS, SOLO LAS VIGENTES Y NO LAS QUE HAN SIDO CANCELADAS
	 */

	private static void obtenerEntradasVendidas(List<Boleta> listaBoletas) {

		if (listaBoletas.size() != 0) {
			for (int i = 0; i < listaBoletas.size(); i++) {

				Boleta boleta = listaBoletas.get(i);

				if (boleta != null && boleta.isVigente()) {
					System.out.println("---------------------------------------\n");
					System.out.println("Numero asiento     : " + boleta.getNumeroAsiento() + "\n");
					System.out.println("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
					System.out.println("Costo Base         : " + boleta.getPrecio() + "\n");
					System.out.println("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
					System.out.println("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
					System.out.println("---------------------------------------\n");

				}

			}

		} else {

			System.out.println("No se han vendido entradas");
		}

	}

	/*
	 * MAIN, SE INICIA EL PROGRAMA
	 */

	public static void main(String[] args) {

		int entradasDisponibles = 10;
		int tipoEvento = 0;
		llenarEventos();

		List<Boleta> listaBoletas = new ArrayList();

		boolean salirPrincipal = false;
		while (!salirPrincipal) {

			System.out.println("****************************************\n");
			System.out.println("Bienvenido a " + nombreTeatro);
			System.out.println("****************************************\n");
			System.out.println("Seleccione el tipo de evento al cual desea asistir:");
			System.out.println("(1) Concierto ");
			System.out.println("(2) Teatro");
			System.out.println("(3) Salir");
			System.out.println("****************************************\n");

			tipoEvento = scanner.nextInt();

			if (tipoEvento == 3) {
				salirPrincipal = salirPrincipal();
			}

			Asiento[] asientos = llenarAsientos(tipoEvento);
			boolean salir = false;
			while (!salir) {
				int opcionMenu = 0;

				System.out.println("MENÚ");

				System.out.println("------------------------------------------");
				System.out.println("(1) Comprar entradas ");
				System.out.println("(2) Ver entradas vendidas ");
				System.out.println("(3) Liberar un asiento vendido");
				System.out.println("(4) Cambiar asiento a una venta ");
				System.out.println("(5) Salir");
				System.out.println("------------------------------------------");
				opcionMenu = scanner.nextInt();

				switch (opcionMenu) {
				case 1:
					Boleta boleta = new Boleta();
					try {
						boleta = comprarEntradas(entradasDisponibles, boleta, tipoEvento, asientos);
						boleta.setVigente(true);
						listaBoletas.add(boleta);
					} catch (Exception e) {
						System.out.println("No fue posible realizar la compra");
					}
					break;
				case 2:
					try {
						obtenerEntradasVendidas(listaBoletas);
					} catch (Exception e) {
						System.out.println("No fue posible obtener las entradas vendidas");
					}
					break;
				case 3:
					try {
						entradasDisponibles = liberarAsiento(ventas, asientos, entradasDisponibles, listaBoletas);

					} catch (Exception e) {
						System.out.println("No fue posible liberar el asiento");
					}

					break;
				case 4:

					try {
						listaBoletas = modificarAsiento(asientos, listaBoletas);

					} catch (Exception e) {
						System.out.println("No fue posible modificar el asiento de la venta");
					}

					break;
				case 5:
					salir = salir();
					break;
				default:
					System.out.println("Ingrese una opcion\n");
				}
			}
		}
	}

	/*
	 * Funcion para llenar asientos de acuerdo al tipo de evento
	 */

	private static boolean salir() {

		return true;
	}

	/*
	 * FUNCION PARA LLENAR LOS ASIENTOS DE ACUERDO A LA OPCION DEL MENU, CONCIERTO O TEATRO
	 */

	private static Asiento[] llenarAsientos(int tipoEvento) {

		Asiento[] asientos = null;
		if (tipoEvento == 1) {
			asientos = llenarAsientosConcierto();
		} else if (tipoEvento == 2) {
			asientos = llenarAsientosTeatro();

		} else {

			System.out.println("El tipo de evento ingresado no existe");
		}
		return asientos;

	}

	/*
	 * FUNCION PARA LLENAR LOS ASIENTOS DISPONIBLES DE UN CONCIERTO
	 */
	public static Asiento[] llenarAsientosConcierto() {

		Evento evento = eventos.get(0);

		Asiento[] asientosConcierto = new Asiento[10];
		Asiento asiento1 = new Asiento();
		asiento1.setNumeroAsiento(1);
		asiento1.setTipoAsiento("General");
		asiento1.setDisponible(true);
		asiento1.setIdEvento(evento);
		asientosConcierto[0] = asiento1;
		Asiento asiento2 = new Asiento();
		asiento2.setNumeroAsiento(2);
		asiento2.setTipoAsiento("General");
		asiento2.setDisponible(true);
		asiento2.setIdEvento(evento);
		asientosConcierto[1] = asiento2;
		Asiento asiento3 = new Asiento();
		asiento3.setNumeroAsiento(3);
		asiento3.setTipoAsiento("Platea");
		asiento3.setDisponible(true);
		asiento3.setIdEvento(evento);
		asientosConcierto[2] = asiento3;
		Asiento asiento4 = new Asiento();
		asiento4.setNumeroAsiento(4);
		asiento4.setTipoAsiento("Platea");
		asiento4.setDisponible(true);
		asiento4.setIdEvento(evento);
		asientosConcierto[3] = asiento4;
		Asiento asiento5 = new Asiento();
		asiento5.setNumeroAsiento(5);
		asiento5.setTipoAsiento("Platea");
		asiento5.setDisponible(true);
		asiento5.setIdEvento(evento);
		asientosConcierto[4] = asiento5;
		Asiento asiento6 = new Asiento();
		asiento6.setNumeroAsiento(6);
		asiento6.setTipoAsiento("VIP");
		asiento6.setDisponible(true);
		asiento6.setIdEvento(evento);
		asientosConcierto[5] = asiento6;
		Asiento asiento7 = new Asiento();
		asiento7.setNumeroAsiento(7);
		asiento7.setTipoAsiento("VIP");
		asiento7.setDisponible(true);
		asiento7.setIdEvento(evento);
		asientosConcierto[6] = asiento7;
		Asiento asiento8 = new Asiento();
		asiento8.setNumeroAsiento(8);
		asiento8.setTipoAsiento("VIP");
		asiento8.setDisponible(true);
		asiento8.setIdEvento(evento);
		asientosConcierto[7] = asiento8;
		Asiento asiento9 = new Asiento();
		asiento9.setNumeroAsiento(9);
		asiento9.setTipoAsiento("VIP");
		asiento9.setDisponible(true);
		asiento9.setIdEvento(evento);
		asientosConcierto[8] = asiento9;
		Asiento asiento10 = new Asiento();
		asiento10.setNumeroAsiento(10);
		asiento10.setTipoAsiento("General");
		asiento10.setDisponible(true);
		asiento10.setIdEvento(evento);
		asientosConcierto[9] = asiento10;

		return asientosConcierto;

	}


	/*
	 * FUNCION PARA LLENAR LOS ASIENTOS DISPONIBLES DE UN TEATRO
	 */
	public static Asiento[] llenarAsientosTeatro() {

		Evento evento = eventos.get(1);

		Asiento[] asientosTeatro = new Asiento[10];
		Asiento asiento1 = new Asiento();
		asiento1.setNumeroAsiento(1);
		asiento1.setTipoAsiento("General");
		asiento1.setDisponible(true);
		asiento1.setIdEvento(evento);
		asientosTeatro[0] = asiento1;
		Asiento asiento2 = new Asiento();
		asiento2.setNumeroAsiento(2);
		asiento2.setTipoAsiento("General");
		asiento2.setDisponible(true);
		asiento2.setIdEvento(evento);
		asientosTeatro[1] = asiento2;
		Asiento asiento3 = new Asiento();
		asiento3.setNumeroAsiento(3);
		asiento3.setTipoAsiento("Platea");
		asiento3.setDisponible(true);
		asiento3.setIdEvento(evento);
		asientosTeatro[2] = asiento3;
		Asiento asiento4 = new Asiento();
		asiento4.setNumeroAsiento(4);
		asiento4.setTipoAsiento("Platea");
		asiento4.setDisponible(true);
		asiento4.setIdEvento(evento);
		asientosTeatro[3] = asiento4;
		Asiento asiento5 = new Asiento();
		asiento5.setNumeroAsiento(5);
		asiento5.setTipoAsiento("Platea");
		asiento5.setDisponible(true);
		asiento5.setIdEvento(evento);
		asientosTeatro[4] = asiento5;
		Asiento asiento6 = new Asiento();
		asiento6.setNumeroAsiento(6);
		asiento6.setTipoAsiento("VIP");
		asiento6.setDisponible(true);
		asiento6.setIdEvento(evento);
		asientosTeatro[5] = asiento6;
		Asiento asiento7 = new Asiento();
		asiento7.setNumeroAsiento(7);
		asiento7.setTipoAsiento("VIP");
		asiento7.setDisponible(true);
		asiento7.setIdEvento(evento);
		asientosTeatro[6] = asiento7;
		Asiento asiento8 = new Asiento();
		asiento8.setNumeroAsiento(8);
		asiento8.setTipoAsiento("VIP");
		asiento8.setDisponible(true);
		asiento8.setIdEvento(evento);
		asientosTeatro[7] = asiento8;
		Asiento asiento9 = new Asiento();
		asiento9.setNumeroAsiento(9);
		asiento9.setTipoAsiento("VIP");
		asiento9.setDisponible(true);
		asiento9.setIdEvento(evento);
		asientosTeatro[8] = asiento9;
		Asiento asiento10 = new Asiento();
		asiento10.setNumeroAsiento(10);
		asiento10.setTipoAsiento("General");
		asiento10.setDisponible(true);
		asiento10.setIdEvento(evento);
		asientosTeatro[9] = asiento10;

		return asientosTeatro;

	}

	private static List<Evento> llenarEventos() {

		Evento evento1 = new Evento();
		evento1.setIdEvento(1);
		evento1.setDescripcionEvento("Concierto");
		eventos.add(evento1);
		Evento evento2 = new Evento();
		evento2.setIdEvento(2);
		evento2.setDescripcionEvento("Teatro");
		eventos.add(evento2);
		return eventos;
	}
}
