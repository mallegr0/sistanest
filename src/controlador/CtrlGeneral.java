package controlador;

import java.util.ArrayList;
import entidades.Anestesia;
import entidades.Anestesista;
import entidades.Medico;
import entidades.ModeloAnestesia;
import entidades.ObraSocial;
import entidades.Sanatorio;
import entidades.TpoAnestesia;
import entidades.Usuario;
import controlador.CtrlAnestesia;
import controlador.CtrlAnestesista;
import controlador.CtrlMedico;
import controlador.CtrlObraSocial;
import controlador.CtrlSanatorio;
import controlador.CtrlTpoAnestesia;
import utilidades.ApplicationException;


public class CtrlGeneral {
	
	//VARIABLES
	private ArrayList<ModeloAnestesia> anestesias = null;
	private ModeloAnestesia modelo2 = null;
	private Anestesia anestesia = null;
	private CtrlAnestesia ctrlAnestesia = null;
	private Anestesista anestesista = null;
	private CtrlAnestesista ctrlAnestesista = null;
	private ObraSocial os = null;
	private CtrlObraSocial cos = null;
	private Medico medico = null;
	private CtrlMedico cm = null; 
	private Sanatorio sanatorio = null;
	private CtrlSanatorio cs = null;
	private TpoAnestesia tpoAnestesia = null;
	private CtrlTpoAnestesia cta = null;
	
	
	//CONSTRUCTOR
	public CtrlGeneral(){}
	
	//METODOS
	
	//Metodo que carga devuelve las anestesias de un anestesista en particular
	public ArrayList<ModeloAnestesia> cargarDatosA(Usuario u){
		//Instancio las variables que declare arriba
		ctrlAnestesia = new CtrlAnestesia();
		anestesista = new Anestesista();
		ctrlAnestesista = new CtrlAnestesista();
		ArrayList<Anestesia> anestesias = new ArrayList<>();
		ArrayList<Anestesia> listado = new ArrayList<>();
		ArrayList<ModeloAnestesia> modelos = new ArrayList<>();
		
		//Primero recupero los datos del anestesista
		anestesista = ctrlAnestesista.buscarAnestesista(u.getUser());//tengo que ver si lo voy a necesitar??
		
		/* Recupero los datos que voy a mostrar:
		 * - Obra Social
		 * - Medico
		 * - Sanatorio
		 * - TpoAnestesia
		 * El resto de los valores los paso de la anestesia directamente
		 */
		//Recupero las anestesias del anestesista activo.
		try {
			for(Anestesia a: ctrlAnestesia.listarAnestesia())
			{
				if(a.getIdAnestesista() == anestesista.getIdAnestesista()){
					listado.add(a);
				}
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		
		//Recorro el listado de anestesias recuperados
		
		if(!listado.isEmpty()){
			for(Anestesia l:listado){
				modelos.add(cargaModelo(l));
			}
		}
		
		return modelos;
	}
	
	//Cargo la instancia del modelo que corresponde a la anestesia activa en el for de arriba
	private ModeloAnestesia cargaModelo(Anestesia l){
		modelo2 = new ModeloAnestesia();
		modelo2.setIdAnestesia(l.getIdAnestesia());
		modelo2.setFecPrestacion(l.getFecPrestacion());
		modelo2.setFecARA(l.getFecAra());
		modelo2.setFecRendicion(l.getFecRendicion());
		modelo2.setAfiliado(l.getAfiliado());
		modelo2.setNroAfiliado(l.getNroAfiliado());
		modelo2.setOsocial(cargaOS(l.getIdOS()));//Ejecuto el metodo para devolver el dato
		modelo2.setNocturno(cambiaTipo(l.getNocturno()));
		modelo2.setFeriado(cambiaTipo(l.getFeriado()));
		modelo2.setFds(cambiaTipo(l.getFds()));
		modelo2.setNroVias(l.getNroVias());
		modelo2.setEdad(l.getEdad());
		modelo2.setNroTalon(l.getNroTalon());
		modelo2.setMedico(cargaMedico(l.getIdMedico()));
		modelo2.setSanatorio(cargaSanatorio(l.getIdSanatorio()));
		modelo2.setTpoAnestesia(cargaTpoAnestesia(l.getIdTpoAnestesia()));
		modelo2.setUsuario(l.getUser());
		return modelo2;
	}
	
	//Metodo que busca la OS cargada en la anestesia que esta siendo parseada al modelo
	private String cargaOS(int id){
		os = new ObraSocial();
		cos = new CtrlObraSocial();
		
		os.setIdOS(id);
		os = cos.consultaObraSocial(os);
		
		return os.getDescOS();
	}
	
	//Metodo que busca el medico cargado en la anestesia que esta siendo parseada al modelo
		private String cargaMedico(int id){
			medico = new Medico();
			cm = new CtrlMedico(); 
			
			medico.setIdMedico(id);
			medico = cm.consultaMedico(medico);
			
			String nombre = medico.getNombreMedico()+" "+medico.getApellidoMedico();
			return nombre;
		}
		
		//Metodo que busca el sanatorio cargado en la anestesia que esta siendo parseada al modelo
		private String cargaSanatorio(int id){
			sanatorio = new Sanatorio();
			cs = new CtrlSanatorio();
			
			sanatorio.setIdSanatorio(id);
			sanatorio = cs.consultaSanatorio(sanatorio);
			
			return sanatorio.getRazonSocial();
		}
		
		//Metodo que busca el tipo de anestesia cargado en la anestesia que esta siendo parseada al modelo
				private String cargaTpoAnestesia(int id){
					tpoAnestesia = new TpoAnestesia();
					cta = new CtrlTpoAnestesia();
					
					tpoAnestesia.setIdTpoAnestesia(id);
					tpoAnestesia = cta.consultaTpoAnestesia(tpoAnestesia);
					
					return tpoAnestesia.getDescTpoAnestesia();
				}
		
	 
	/*En el modelo puse que las variables Nocturno, Feriado y Fin de semana sean booleanos,
	 * como MySql no acepta tipo de datos booleanos, esas variables pasaron a ser Integer, 
	 * con lo cual este metodo lo que hace es ver que nro es y devolver V o F
	 * Convencion:
	 * 0 - Falso
	 * 1 - Verdadero
	 */
	private boolean cambiaTipo(int nro){
		if(nro == 0){
			return false;
		}
		else{
			return true;
		}
	}
}
