package fr.imie.contact.servlets;

import fr.imie.contact.entities.Person;
import fr.imie.contact.repositories.PersonRepository;
import fr.imie.contact.repositories.PersonRepositoryMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

  private PersonRepository repository = new PersonRepositoryMock();

  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    List<Person> persons = repository.findAll();
    request.setAttribute("persons", persons);
    request.getRequestDispatcher("person.jsp").forward(request, response);
  }

}
