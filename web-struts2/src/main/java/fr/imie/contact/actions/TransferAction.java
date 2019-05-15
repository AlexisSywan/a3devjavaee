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

@WebServlet("/transfer/*")

public class TransferAction extends HttpServlet {
    @Inject
    private BankAccountRepository bankAccountRepository;
    @Inject
    private PersonRepository personRepository;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("post")) {

            Integer idDebit = Integer.parseInt(request.getParameter("debitAccount"));
            Integer idCredit = Integer.parseInt(request.getParameter("creditAccount"));
            BigDecimal ammount = new BigDecimal(request.getParameter("ammount"));
            BankAccount debit = bankAccountRepository.findById(idDebit);
            BankAccount credit = bankAccountRepository.findById(idCredit);
            debit.setId(idDebit);
            credit.setId(idCredit);
            debit.setBalance(debit.getBalance().subtract(ammount));
            credit.setBalance(credit.getBalance().add(ammount));


            bankAccountRepository.save(debit);
            bankAccountRepository.save(credit);
        }


        List<BankAccount> accounts = bankAccountRepository.findAll();
        List<Person> persons = personRepository.findAll();
        request.setAttribute("accounts", accounts);
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(request, response);
    }
}
