package fr.imie.contact.servlets;

import fr.imie.contact.repositories.PersonRepository;
import fr.imie.contact.repositories.PersonRepositoryMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

  private PersonRepository repository = new PersonRepositoryMock();

  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    //
    request.getRequestDispatcher("person.jsp").forward(request, response);
  }

}
