package fr.imie.contact.actions;

import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@WebServlet("/bankaccount/*")
public class BankAccountServlet extends HttpServlet {

    @Inject
    private BankAccountRepository bankAccountRepository;
    @Inject
    private PersonRepository personRepository;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("post")) {

            BankAccount account = new BankAccount();

            Integer id = Integer.parseInt(request.getParameter("owner"));
            BigDecimal balance = new BigDecimal(request.getParameter("balance"));
            Person owner = personRepository.findById(id);
            owner.setId(id);
            account.setBalance(balance);
            account.setOwner(owner);
            bankAccountRepository.save(account);
        }

        List<BankAccount> accounts = bankAccountRepository.findAll();
        List<Person> persons = personRepository.findAll();
        request.setAttribute("accounts", accounts);
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/views/bankaccount.jsp").forward(request, response);
    }

}
