package br.ufrn.telefoneme.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrn.telefoneme.dados.Dados;
import br.ufrn.telefoneme.dto.CursoDTO;

public class TelaCursos extends JFrame {

	private JPanel contentPane;
	private JComboBox box;
	private String[] items = {"An", "Aus"};
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLayout(new FlowLayout());
		
		List<String> cursoNomes = new ArrayList<String>();
		Dados dados = new Dados();
		for(CursoDTO curso : dados.getCursos()){
			cursoNomes.add(curso.getCurso());
		}
		box = new JComboBox(cursoNomes.toArray());
		add(box);
	}

}
