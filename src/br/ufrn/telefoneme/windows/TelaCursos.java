package br.ufrn.telefoneme.windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.connection.ArchiveConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

@SuppressWarnings("serial")
public class TelaCursos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private HashMap<String, Component> componentMap;
	private AbstractConnection connection = new ArchiveConnection();//new APIConnection();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCursos frame = new TelaCursos(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ConnectionException 
	 * @throws JsonStringInvalidaException 
	 */
	public TelaCursos(String[] args ) throws JsonStringInvalidaException, ConnectionException {
		JComboBox<Item> box;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new FlowLayout());
		
		Vector<Item> model = new Vector<Item>();
        model.addElement( new Item("0", "Selecione" ) );

        String nomeCurso;
        //TODO Colocar janela de aviso!
		for(CursoDTO curso : FachadaDeDados.getInstance().getCursos(connection)){
			nomeCurso = curso.getCurso() + "/" + curso.getUnidade() + " - " + curso.getMunicipio() + " - " + curso.getNivel();
			model.addElement( new Item(curso.getIdCurso().toString(), nomeCurso ) );
		}
		box = new JComboBox<Item>(model);
		box.setName("Cursos");
		box.setEnabled(true);
		box.addActionListener( this );
        
        JLabel label = new JLabel("Curso");
        getContentPane().add(label);
        getContentPane().add(box, BorderLayout.NORTH );

		model = new Vector<Item>();
        model.addElement( new Item("0", "Selecione" ) );
		box = new JComboBox<Item>(model);
		box.setName("Matriz");
		box.setEnabled(true);
		box.addActionListener( this );
        
        JLabel lblMatrizCurricular = new JLabel("Matriz Curricular");
        getContentPane().add(lblMatrizCurricular);
        getContentPane().add(box, BorderLayout.SOUTH );
		
        createComponentMap();
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e)
    {
        JComboBox<Item> comboBox = (JComboBox<Item>)e.getSource();
        Item item = (Item)comboBox.getSelectedItem();
        if(!comboBox.equals((JComboBox<?>) getComponentByName("Matriz"))){
	        comboBox = (JComboBox<Item>) getComponentByName("Matriz");
	        Integer idCurso = Integer.parseInt(item.getId());
	        Vector<Item> model = new Vector<Item>();
	        model.addElement( new Item("0", "Selecione" ) );

	        String nomeMatriz;
			try {
				for(MatrizCurricularDTO matriz : FachadaDeDados.getInstance().getMatrizes(connection,idCurso)){
					nomeMatriz = matriz.getNome() + " - " + matriz.getMunicipio() + " - " + matriz.getModalidade() + " - ";
					if(matriz.getEnfase() != null)
						nomeMatriz += matriz.getEnfase() + " - ";
					nomeMatriz += matriz.getTurno();
					if(!matriz.getAtivo())
						nomeMatriz += "(Inativo)";
				    model.addElement( new Item(new Item (matriz.getIdCurriculo().toString(), matriz.getTurno()), nomeMatriz ) );
				}
			} catch (IdException | JsonStringInvalidaException | ConnectionException e1) {
				e1.printStackTrace();
			}
			DefaultComboBoxModel<Item> modelo = new DefaultComboBoxModel<Item>(model);
			comboBox.setModel(modelo);
			comboBox.setEnabled(true);
			comboBox.addActionListener( this );
	        getContentPane().add(comboBox, BorderLayout.SOUTH );
    	}
        else{
        	String[] aux = item.getId().split(" . ");
        	Integer idCurriculo = Integer.parseInt(aux[0]);
        	String turno = aux[1];
        	TelaEstruturaCurricular.main(connection, idCurriculo, turno);
        }
    }
	
	public class Item
	{
	    private String id;
	    private String description;

        public Item(String id, String description)
        {
            this.id = id;
            this.description = description;
        }
        
        public Item(Item item, String description) {
			this.id = item.getId() + " . " + item.getDescription();
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public String getId() {
			return id;
		}

		@Override
	    public String toString()
        {
            return description;
        }
	}
	
	private void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] components = getContentPane().getComponents();
        for (int i=0; i < components.length; i++) {
        	componentMap.put(components[i].getName(), components[i]);
        }
	}
	
	public Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	        	return (Component) componentMap.get(name);
	        }
	        else return null;
	}
}
