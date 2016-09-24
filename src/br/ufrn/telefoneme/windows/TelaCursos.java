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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrn.telefoneme.dados.Dados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.IdException;

public class TelaCursos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private HashMap componentMap;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCursos frame = new TelaCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCursos() {
		JComboBox<Item> box;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLayout(new FlowLayout());
		
		Vector<Item> model = new Vector<Item>();
        model.addElement( new Item((long) 0, "Selecione" ) );
		Dados dados = new Dados();
		String nomeCurso;
		for(CursoDTO curso : dados.getCursos()){
			nomeCurso = curso.getCurso() + "/" + curso.getUnidade() + " - " + curso.getMunicipio() + " - " + curso.getNivel();
	        model.addElement( new Item((long) curso.getIdCurso(), nomeCurso ) );
		}
		box = new JComboBox<Item>(model);
		box.setName("Cursos");
		box.setEnabled(true);
		box.addActionListener( this );
        getContentPane().add(box, BorderLayout.NORTH );

		model = new Vector<Item>();
        model.addElement( new Item((long) 0, "Selecione" ) );
		box = new JComboBox<Item>(model);
		box.setName("Matriz");
		box.setEnabled(true);
		box.addActionListener( this );
        getContentPane().add(box, BorderLayout.SOUTH );
		
        createComponentMap();
	}
	
	public void actionPerformed(ActionEvent e)
    {
        JComboBox<?> comboBox = (JComboBox<?>)e.getSource();
        Item item = (Item)comboBox.getSelectedItem();
        comboBox = (JComboBox<?>) getComponentByName("Matriz");
        Integer idCurso = item.getId();
        Vector<Item> model = new Vector<Item>();
        model.addElement( new Item((long) 0, "Selecione" ) );
        Dados dados = new Dados();
        String nomeMatriz;
		try {
			for(MatrizCurricularDTO matriz : dados.getMatrizes(idCurso)){
				nomeMatriz = matriz.getNome() + " - " + matriz.getMunicipio() + " - " + matriz.getModalidade() + " - ";
				if(matriz.getEnfase() != null)
					nomeMatriz += matriz.getEnfase() + " - ";
				nomeMatriz += matriz.getTurno();
				if(!matriz.getAtivo())
					nomeMatriz += "(Inativo)";
			    model.addElement( new Item(matriz.getIdCurriculo(), nomeMatriz ) );
			}
		} catch (IdException e1) {
			e1.printStackTrace();
		}
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(model);
		comboBox.setModel(modelo);
		comboBox.setEnabled(true);
		comboBox.addActionListener( this );
        getContentPane().add(comboBox, BorderLayout.SOUTH );
        
        System.out.println( item.getId() + " : " + item.getDescription() );
    }
	
	public class Item
	{
	    private Long id;
	    private String description;

        public Item(Long id, String description)
        {
            this.id = id;
            this.description = description;
        }

		public String getDescription() {
			return description;
		}

		public Integer getId() {
			return id.intValue();
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
