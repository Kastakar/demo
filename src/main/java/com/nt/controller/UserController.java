package com.nt.controller;

import java.awt.Color;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.UserDetails;
import com.nt.repo.UserDetailsRepo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {
	
	@Autowired
	UserDetailsRepo detailsRepo;
	
	@GetMapping("/userDetails")
	public String userDetails(Model model)
	{

		
		List<UserDetails> findAll = detailsRepo.findAll();
		model.addAttribute("users", findAll);
		System.out.println("Added Changes");
		
		System.out.println(detailsRepo.findByCityIn(List.of("Rajura","Takali")));
	
		
		System.out.println("-----------------------------------");
		
		
		System.out.println(detailsRepo.findByCityLike("%u%"));
		
System.out.println("-----------------------------------");
		
		


		System.out.println(detailsRepo.findByCityLike("%u%"));
		
		
		System.out.println("-----------------------------------");
		
	//	List<UserDetails> findByStatusIsTrueAndCityEquals = detailsRepo.findByStatusIsTrueAndCityEquals("Rajura");		
		
		return "addUser";
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws DocumentException, IOException
	{
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        
         
List<UserDetails> findAll = detailsRepo.findAll();
		
		Document document = new Document(PageSize.A4);
		   PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Users", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	        
	        
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
	        font1.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("User ID", font1));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Active_Switch", font1));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Email-Address", font1));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Mobile Number", font1));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("UserName", font1));
	        table.addCell(cell);       
	         
	       for(UserDetails detail: findAll)
	       {
	    	   table.addCell(String.valueOf(detail.getUserId()));
	    	   table.addCell(detail.getActiveSwitch());
	    	   table.addCell(detail.getEmailAddress());
	    	   table.addCell(detail.getMobileNumber());
	    	  
	    	   table.addCell(detail.getUserName());
	       }
	       document.add(table);
	         
	        document.close();
	}
	
	
	
	}
	
	
	
	


