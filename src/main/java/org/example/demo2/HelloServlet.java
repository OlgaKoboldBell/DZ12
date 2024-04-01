package org.example.demo2;

import java.io.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "jdbc:mysql://localhost:3306/notebooks";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(url, user, pass)) {
//                String comand = "create table Product(\n" +
//                        "    id int primary key auto_increment,\n" +
//                        "    name varchar(255) not null,\n" +
//                        "    Company_name varchar(255) null,\n" +
//                        "    Number_of_pages decimal null, \n" +
//                        "    Cover_type varchar(255) null,\n" +
//                        "    Producing_country varchar(255) null,\n" +
//                        "    Appearance varchar(255) null\n" +
//                        ")";

//            String command = "insert Product (name, Company_name, Number_of_pages, Cover_type, Producing_country, Appearance) " +
//                    "values ('Ромашка' , 'Аврора', 20, 'soft', 'Китай', 'лінія'),\n" +
//                    "('Троянда' , 'Аврора', 30, 'soft', 'Китай', 'клітинка'),\n"+
//                    "('Конвалія' , 'Аврора', 20, 'soft', 'Україна', 'лінія'),\n" +
//                "('Лілея' , 'Аврора', 40, 'soft', 'Україна', 'лінія'),\n"+
//                        "('Хризантема' , 'Аврора', 40, 'soft', 'Україна', 'лінія'),\n" +
//                "('Орхідея' , 'Аврора', 40, 'soft', 'Україна', 'порожньо'),\n"+
//                    "('Мальва' , 'Аврора', 40, 'soft', 'Англія', 'лінія'),\n" +
//                    "('Рута' , 'Аврора', 40, 'soft', 'США', 'порожньо')\n";
//                Statement stat = connection.createStatement();
//                stat.executeUpdate(command);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                String commandRead = "select * from Product";
                Statement stat = connection.createStatement();
                ResultSet result = stat.executeQuery(commandRead);


                out.println("<html><body>");
//                out.println("<h1>" + "Інформація про всі блокноти" + "</h1>");
//
//                out.println("<table>");
//                out.println("<tr> <th> id </th> <th> name </th> <th>Company_name</th> <th>Number_of_pages</th> <th>Cover_type</th><th>Producing_country</th><th>Appearance</th></tr> ");
//                while (result.next()) {
//                    int id = result.getInt("id");
//                    String name = result.getString("name");
//                    String Company_name = result.getString("Company_name");
//                    double Number_of_pages = result.getDouble("Number_of_pages");
//                    String Cover_type = result.getString("Cover_type");
//                    String Producing_country = result.getString("Producing_country");
//                    String Appearance = result.getString("Appearance");
//                    out.println("<tr> <td> " + id + "</td> <td> " + name + " </td> <td>" + Company_name + "</td> <td>" + Number_of_pages + "</td> <td>" + Cover_type + "</td><td>" + Producing_country + "</td><td>" + Appearance + "</td></tr> ");
//                }
//                out.println("</table>");
//
//                out.println("<h1>" + "Усі країни-виробники" + "</h1>");
//
//                out.println("<ul>");
//                String command = "SELECT DISTINCT Producing_country FROM Product";
//                stat = connection.createStatement();
//                result = stat.executeQuery(command);
//                while (result.next()) {
//                    String producingCountry = result.getString("Producing_country");
//                    out.println("<li>" + producingCountry + "</li>");
//                }
//                out.println("</ul>");
//
//                out.println("<h1>" + "Назви країн та кількість блокнотів із кожної країни" + "</h1>");
//
//                out.println("<table>");
//                out.println("<tr><th>Країна</th><th>Кількість блокнотів</th></tr>");
//
//                command = "SELECT Producing_country, COUNT(*) AS notebook_count FROM Product GROUP BY Producing_country";
//                stat = connection.createStatement();
//                result = stat.executeQuery(command);
//
//                while (result.next()) {
//                    String country = result.getString("Producing_country");
//                    int notebookCount = result.getInt("notebook_count");
//                    out.println("<tr><td>" + country + "</td><td>" + notebookCount + "</td></tr>");
//                }
//
//                out.println("</table>");
//
//                out.println("<h1>" + "Назва фірми-виробника та кількість блокнотів кожної з них" + "</h1>");
//
//                out.println("<table>");
//                out.println("<tr><th>Фірма-виробник</th><th>Кількість блокнотів</th></tr>");
//
//                command = "SELECT Company_name, COUNT(*) AS notebook_count FROM Product GROUP BY Company_name";
//                stat = connection.createStatement();
//                result = stat.executeQuery(command);
//
//                while (result.next()) {
//                    String company = result.getString("Company_name");
//                    int notebookCount = result.getInt("notebook_count");
//                    out.println("<tr><td>" + company + "</td><td>" + notebookCount + "</td></tr>");
//                }
//
//                out.println("</table>");
//
//                out.println("<h2>Країна з найбільшою кількістю блокнотів:</h2>");
//                String maxNotebooksCountryQuery = "SELECT Producing_country, COUNT(*) AS notebook_count " +
//                        "FROM Product " +
//                        "GROUP BY Producing_country " +
//                        "ORDER BY notebook_count DESC " +
//                        "LIMIT 1";
//
//                stat = connection.createStatement();
//                ResultSet maxNotebooksCountryResult = stat.executeQuery(maxNotebooksCountryQuery);
//
//                if (maxNotebooksCountryResult.next()) {
//                    String maxCountry = maxNotebooksCountryResult.getString("Producing_country");
//                    int maxCount = maxNotebooksCountryResult.getInt("notebook_count");
//                    out.println("Країна: " + maxCountry + ", кількість блокнотів: " + maxCount);
//                } else {
//                    out.println("Дані відсутні.");
//                }
//                out.println("<br>");
//
//                out.println("<h2>Країна з найменшою кількістю блокнотів:</h2>");
//                String minNotebooksCountryQuery = "SELECT Producing_country, COUNT(*) AS notebook_count " +
//                        "FROM Product " +
//                        "GROUP BY Producing_country " +
//                        "ORDER BY notebook_count " +
//                        "LIMIT 1";
//                ResultSet minNotebooksCountryResult = stat.executeQuery(minNotebooksCountryQuery);
//                if (minNotebooksCountryResult.next()) {
//                    String minCountry = minNotebooksCountryResult.getString("Producing_country");
//                    int minCount = minNotebooksCountryResult.getInt("notebook_count");
//                    out.println("Країна: " + minCountry + ", кількість блокнотів: " + minCount);
//                } else {
//                    out.println("Дані відсутні.");
//                }
//                out.println("<br>");
//
//                out.println("<h2>Виробник з найбільшою кількістю блокнотів:</h2>");
//                String maxNotebooksCompanyQuery = "SELECT Company_name, COUNT(*) AS notebook_count " +
//                        "FROM Product " +
//                        "GROUP BY Company_name " +
//                        "ORDER BY notebook_count DESC " +
//                        "LIMIT 1";
//                ResultSet maxNotebooksCompanyResult = stat.executeQuery(maxNotebooksCompanyQuery);
//                if (maxNotebooksCompanyResult.next()) {
//                    String maxCompany = maxNotebooksCompanyResult.getString("Company_name");
//                    int maxCount = maxNotebooksCompanyResult.getInt("notebook_count");
//                    out.println("Виробник: " + maxCompany + ", кількість блокнотів: " + maxCount);
//                } else {
//                    out.println("Дані відсутні.");
//                }
//                out.println("<br>");
//
//                out.println("<h2>Виробник з найменшою кількістю блокнотів:</h2>");
//                String minNotebooksCompanyQuery = "SELECT Company_name, COUNT(*) AS notebook_count " +
//                        "FROM Product " +
//                        "GROUP BY Company_name " +
//                        "ORDER BY notebook_count " +
//                        "LIMIT 1";
//                ResultSet minNotebooksCompanyResult = stat.executeQuery(minNotebooksCompanyQuery);
//                if (minNotebooksCompanyResult.next()) {
//                    String minCompany = minNotebooksCompanyResult.getString("Company_name");
//                    int minCount = minNotebooksCompanyResult.getInt("notebook_count");
//                    out.println("Виробник: " + minCompany + ", кількість блокнотів: " + minCount);
//                } else {
//                    out.println("Дані відсутні.");
//                }
//                out.println("<br>");
//
//                out.println("<h2>Блокноти з твердою обкладинкою:</h2>");
//                String hardcoverQuery = "SELECT * FROM Product WHERE Cover_type = 'hard'";
//                ResultSet hardcoverResult = stat.executeQuery(hardcoverQuery);
//                out.println("<ul>");
//                while (hardcoverResult.next()) {
//                    String name = hardcoverResult.getString("name");
//                    out.println("<li>" + name + "</li>");
//                }
//                out.println("</ul>");
//                out.println("<br>");
//
//                out.println("<h2>Блокноти з м'якою обкладинкою:</h2>");
//                String softcoverQuery = "SELECT * FROM Product WHERE Cover_type = 'soft'";
//                ResultSet softcoverResult = stat.executeQuery(softcoverQuery);
//                out.println("<ul>");
//                while (softcoverResult.next()) {
//                    String name = softcoverResult.getString("name");
//                    out.println("<li>" + name + "</li>");
//                }
//                out.println("</ul>");

                out.println("<h1>Завдання 4.1. Показати всі блокноти конкретної країни</h1>");
                String selectedCountry = request.getParameter("country");
                out.println("<h2>Виберіть країну-виробника:</h2>");
                out.println("<form action='' method='get'>");
                out.println("<select name='country'>");
                out.println("<option value='Україна'>Україна</option>");
                out.println("<option value='Китай'>Китай</option>");
                out.println("<option value='Англія'>Англія</option>");
                out.println("<option value='США'>США</option>");
                out.println("</select>");
                out.println("<input type='submit' value='Вибрано'>");
                out.println("</form>");

                if (selectedCountry != null && !selectedCountry.isEmpty()) {
                    try {
                        String query = "SELECT * FROM Product WHERE Producing_country=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, selectedCountry);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        // Виведення результатів
                        out.println("<h2>Блокноти виробника з країни " + selectedCountry + ":</h2>");
                        out.println("<ul>");
                        while (resultSet.next()) {
                            String notebookName = resultSet.getString("name");
                            out.println("<li>" + notebookName + "</li>");
                        }
                        out.println("</ul>");


                    } catch (Exception e) {
                        out.println("Помилка: " + e.getMessage());
                    }
                }
                out.println("<h1>Завдання 4.3. Створити фільтр по кількості сторінок</h1>");
                String pageCount = request.getParameter("pageCount");
                out.println("<h1>Фільтр по кількості сторінок</h1>");
                out.println("<h2>Введіть кількість сторінок:</h2>");
                out.println("<form action='' method='get'>");
                out.println("<input type='text' name='pageCount'>");
                out.println("<input type='submit' value='Фільтрувати'>");
                out.println("</form>");


                // Показати блокноти з кількістю сторінок нижче вказаної у формі
                if (pageCount != null && !pageCount.isEmpty()) {
                    try {
                        int pages = Integer.parseInt(pageCount);

                        String query = "SELECT * FROM Product WHERE Number_of_pages < ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, pages);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        // Виведення результатів
                        out.println("<h2>Блокноти з кількістю сторінок менше " + pageCount + ":</h2>");
                        out.println("<ul>");
                        while (resultSet.next()) {
                            String notebookName = resultSet.getString("name");
                            out.println("<li>" + notebookName + "</li>");
                        }
                        out.println("</ul>");

                    } catch (NumberFormatException e) {
                        out.println("Помилка: Введіть коректну кількість сторінок.");
                    }

                }

                out.println("<h1>Фільтр за зовнішнім виглядом</h1>");
                out.println("<h2>Введіть бажаний зовнішній вигляд:</h2>");
                out.println("<form action='' method='get'>");
                out.println("<input type='text' name='appearance'>");
                out.println("<input type='submit' value='Фільтрувати'>");
                out.println("</form>");

                String appearance = request.getParameter("appearance");
                if (appearance != null && !appearance.isEmpty()) {
                    try {
                        String query = "SELECT * FROM Product WHERE Appearance=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, appearance);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        out.println("<h2>Блокноти зі зовнішнім виглядом \"" + appearance + "\":</h2>");
                        out.println("<ul>");
                        while (resultSet.next()) {
                            String notebookName = resultSet.getString("name");
                            out.println("<li>" + notebookName + "</li>");
                        }
                        out.println("</ul>");

                    } catch (SQLException e) {
                        out.println("Помилка: " + e.getMessage());
                    }
                }

                out.println("</body></html>");


            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}