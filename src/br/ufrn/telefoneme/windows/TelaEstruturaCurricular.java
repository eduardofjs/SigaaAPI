package br.ufrn.telefoneme.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.IdException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class TelaEstruturaCurricular extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public void main(Integer idCurriculo, String turno) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstruturaCurricular frame = new TelaEstruturaCurricular(idCurriculo,turno);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IdException 
	 */
	public TelaEstruturaCurricular(Integer idCurriculo, String turno) throws IdException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1424, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
		);

		List<ComponenteCurricularDTO> componentes = FachadaDeDados.getInstance().getComponentes(idCurriculo);
		JScrollPane scrollPane;
		int totalSemestres = 0;
		for(ComponenteCurricularDTO componente : componentes){
			if(componente.getSemetreOferta() > totalSemestres)
				totalSemestres = componente.getSemetreOferta();
		}
		
		for(int semestreAtual = 1; semestreAtual <= totalSemestres; semestreAtual++){
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"M1", null, null, null, null, null, null},
					{"M2", null, null, null, null, null, null},
					{"M3", null, null, null, null, null, null},
					{"M4", null, null, null, null, null, null},
					{"M5", null, null, null, null, null, null},
					{"M6", null, null, null, null, null, null},
					{"T1", null, null, null, null, null, null},
					{"T2", null, null, null, null, null, null},
					{"T3", null, null, null, null, null, null},
					{"T4", null, null, null, null, null, null},
					{"T5", null, null, null, null, null, null},
					{"T6", null, null, null, null, null, null},
					{"N1", null, null, null, null, null, null},
					{"N2", null, null, null, null, null, null},
					{"N3", null, null, null, null, null, null},
					{"N4", null, null, null, null, null, null},
				},
				new String[] {
					"Horários", "Segunda-feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"
				}
			));
			
			
			
			for(ComponenteCurricularDTO componente : componentes){
				int cargaHoraria = componente.getCargaHorariaTotal();
				if(componente.getSemetreOferta() == semestreAtual){
					if(cargaHoraria%90 == 0){
						int horario;
						int qtdHorario = 2*(cargaHoraria/90);
						if(turno.equals("M") || turno.equals("MT") || turno.equals("MTN"))
							horario = 0;
						else if(turno.equals("T") || turno.equals("TN"))
							horario = 6;
						else
							horario = 12;
						for(int i = horario; i < 15 && cargaHoraria > 0; i++){
							for(int j = 1; j < 7; j+=2){
								if(table.getValueAt(i, j) == null){
									for(int k = i; k < i + qtdHorario; k++){
										table.setValueAt(componente.getNome(), k, j);
										cargaHoraria -= 30;
									}
								}
							}
						}
					}
				}
			}
			
			scrollPane = new JScrollPane();
			tabbedPane.addTab(semestreAtual + "º Semestre", null, scrollPane, null);
			scrollPane.setViewportView(table);
		}
		getContentPane().setLayout(groupLayout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
