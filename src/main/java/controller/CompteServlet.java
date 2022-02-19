package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compte;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation = request.getParameter("operation");
		List<Compte> comptes = new ArrayList<Compte>();
		
		if(operation.equals("creer")) {
			
			String titulaire = request.getParameter("titulaire");
			int numeroCompte = Integer.parseInt(request.getParameter("numeroCompte"));
			double solde = Double.parseDouble(request.getParameter("montant"));
			
			Compte nouveauCompte = new Compte(titulaire, numeroCompte, solde);
			
			try {
	        	
	            FileInputStream fis = new FileInputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            comptes = (ArrayList<Compte>) ois.readObject();
	            ois.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
	    
	        //ajouter dans cette liste la nouvelle personne
	        comptes.add(nouveauCompte);
	        
	        //sérialiser la nouvelle liste
	        
	        try {
	        	
	            FileOutputStream fs = new FileOutputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(comptes);
	            os.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
			
	        request.setAttribute("nouveaucompte", nouveauCompte);
			this.getServletContext().getRequestDispatcher("/WEB-INF/operation.jsp").
			forward(request, response);
			
			
		} else if(operation.equals("debiter")) {
			
			Double debit = Double.parseDouble(request.getParameter("montant"));
			int numeroCompte = Integer.parseInt(request.getParameter("numeroCompte"));
			
			try {
	        	
	            FileInputStream fis = new FileInputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            comptes = (ArrayList<Compte>) ois.readObject();
	            ois.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
			
			double nouveausolde = 0;
			
			for (int i = 0; i < comptes.size(); i++) {
				
				
				if(comptes.get(i).getNumero() == numeroCompte) {
					
					nouveausolde = comptes.get(i).getSolde();
					
				}
				
			}
			
			nouveausolde = nouveausolde - debit;
			
			for (int i = 0; i < comptes.size(); i++) {
				
				
				if(comptes.get(i).getNumero() == numeroCompte) {
					
					comptes.get(i).setSolde(nouveausolde);
					
				}
				
			}
			
			try {
	        	
	            FileOutputStream fs = new FileOutputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(comptes);
	            os.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
			
			request.setAttribute("nouveausolde", nouveausolde);
			this.getServletContext().getRequestDispatcher("/WEB-INF/operation.jsp").
			forward(request, response);
			
			
		} else if(operation.equals("crediter")) {
			
			double credit = Double.parseDouble(request.getParameter("montant"));
			int numeroCompte = Integer.parseInt(request.getParameter("numeroCompte"));
			
			try {
	        	
	            FileInputStream fis = new FileInputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            comptes = (ArrayList<Compte>) ois.readObject();
	            ois.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
			
			double nouveausolde = 0;
			
			for (int i = 0; i < comptes.size(); i++) {
				
				
				if(comptes.get(i).getNumero() == numeroCompte) {
					
					nouveausolde = comptes.get(i).getSolde();
					
				}
				
			}
			
			nouveausolde += credit;
			
			for (int i = 0; i < comptes.size(); i++) {
				
				if(comptes.get(i).getNumero() == numeroCompte) {
					
					comptes.get(i).setSolde(nouveausolde);
					
				}
				
			}
			
			try {
	        	
	            FileOutputStream fs = new FileOutputStream("C:\\Users\\steve\\eclipse-workspace\\banque\\comptes.txt");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(comptes);
	            os.close();
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
			
			request.setAttribute("nouveausolde", nouveausolde);
			this.getServletContext().getRequestDispatcher("/WEB-INF/operation.jsp").
			forward(request, response);
			
		} else {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/operation.jsp").
			forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
