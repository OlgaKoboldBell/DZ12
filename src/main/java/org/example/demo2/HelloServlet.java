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
        String url = "jdbc:mysql://localhost:3306/sales";
        String user = "root";
        String pass = "";
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(url, user, pass)) {

//                String command = "create table Sellers(\n" +
//                        "    id int primary key auto_increment,\n" +
//                        "    name_seller varchar(255) not null,\n" +
//                        "    contact_seller varchar(255) null,\n" +
//                        "    email_seller varchar(255) null\n" +
//                        ")";

//                String command1 = "create table Buyers(\n" +
//                        "    id int primary key auto_increment,\n" +
//                        "    name_buyer varchar(255) not null,\n" +
//                        "    contact_buyer varchar(255) null,\n" +
//                        "    email_buyer varchar(255) null\n" +
//                        ")";
//                String command2 = "create table Products(\n" +
//                        "    id int primary key auto_increment,\n" +
//                        "    name_product varchar(255) not null,\n" +
//                        "    count_product int null,\n" +
//                        "    price_product decimal null\n" +
//                        ")";
//                String command3 = "create table Sales(\n" +
//                        "    id int primary key auto_increment,\n" +
//                        "    seller_id int not null, INDEX (seller_id), FOREIGN KEY (seller_id)REFERENCES Sellers(id),\n" +
//                        "    buyer_id int not null, INDEX (buyer_id), FOREIGN KEY (buyer_id)REFERENCES Buyers(id),\n" +
//                        "    product_id int not null, INDEX (product_id), FOREIGN KEY (product_id)REFERENCES Products(id),\n" +
//                        "    price_sale decimal not null,\n" +
//                        "    date_sale date not null\n" +
//                        ")";

//
//                Statement stat1 = connection.createStatement();
//                stat1.executeUpdate(command1);
//                Statement stat2 = connection.createStatement();
//                stat2.executeUpdate(command2);
//                Statement stat3 = connection.createStatement();
//                stat3.executeUpdate(command3);


//                            String command = "insert Sellers (name_seller, contact_seller, email_seller) " +
//                    "values ('Іванов В. В.' , '123456', 'кен@jkkl'),\n" +
//                    "('Іванов В. В.' , '1234566', 'кен@jkkl'),\n"+
//                    "('Петров В. В.' , '7654389', 'jkl@jkkl'),\n" +
//                    "('Шевченко В. В.' , '4566788', 'tyu@jkkl'),\n"+
//                    "('Гончаренко В. В.' , '7677888', 'кyhj@jkkl'),\n" +
//                    "('Коваленко В. В.' , '4566788', 'ghj@jkkl'),\n"+
//                    "('Петренко В. В.' , '1235556', 'yui@jkkl'),\n" +
//                    "('Іваненко В. В.' , '1323456', 'uio@jkkl')\n";
//
//                String command = "insert Buyers (name_buyer, contact_buyer, email_buyer) " +
//                        "values ('Іванчук В. В.' , '123456', 'кен@jkkl'),\n" +
//                        "('Іванович В. В.' , '1234566', 'кен@jkkl'),\n"+
//                        "('Петрончук В. В.' , '7654389', 'jkl@jkkl'),\n" +
//                        "('Шевчук В. В.' , '4566788', 'tyu@jkkl'),\n"+
//                        "('Гончар В. В.' , '7677888', 'кyhj@jkkl'),\n" +
//                        "('Ковальчук В. В.' , '4566788', 'ghj@jkkl'),\n"+
//                        "('Петронюк В. В.' , '1235556', 'yui@jkkl'),\n" +
//                        "('Іванчик В. В.' , '1323456', 'uio@jkkl')\n";

//                String command = "insert Products (name_product, count_product, price_product) " +
//                        "values ('Диван' , '123', '12.000'),\n" +
//                        "('Шафа' , '65', '8.550'),\n"+
//                        "('Крісло' , '100', '7.500'),\n" +
//                        "('Стіл' , '450', '4.800'),\n"+
//                        "('Стілець' , '700', '1.760'),\n" +
//                        "('Кухня' , '70', '11.900'),\n"+
//                        "('Стіл маленький' , '125', '4.900'),\n" +
//                        "('Тумба' , '300', '5.300')\n";


//                String command = "insert Sales (seller_id, buyer_id, product_id, price_sale ,date_sale) " +
//                        "values (1, 1, 1, 12.900, '2024-03-21'),\n" +
//                        "(1, 2, 2, 8.570, '2024-03-22'),\n"+
//                        "(1, 3, 3, 8.100, '2024-03-24'),\n" +
//                        "(2, 1, 4, 4.880, '2024-03-22'),\n"+
//                        "(3, 1, 1, 12.900, '2024-03-20'),\n" +
//                        "(3, 1, 8, 12.900, '2024-03-28'),\n"+
//                        "(4, 1, 1, 12.900, '2024-03-30'),\n" +
//                        "(5, 6, 7, 12.900, '2024-03-15'),\n" +
//                        "(6, 5, 1, 4.600, '2024-03-21'),\n"+
//                        "(7, 7, 5, 12.900, '2024-03-21'),\n" +
//                        "(5, 1, 6, 10.900, '2024-03-15'),\n" +
//                        "(6, 8, 6, 12.900, '2024-03-21'),\n"+
//                        "(8, 4, 7, 5.900, '2024-03-21'),\n" +
//                        "(8, 1, 1, 13.900, '2024-03-21')\n";
//
//                Statement stat = connection.createStatement();
//                stat.executeUpdate(command);


                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                String commandRead = "select * from Sellers";
                Statement stat = connection.createStatement();
                ResultSet result = stat.executeQuery(commandRead);


                out.println("<html><body>");
                out.println("<h1>" + "Інформація про продавців" + "</h1>");

                out.println("<table>");
                out.println("<tr> <th> id </th> <th>name_seller</th> <th>contact_seller</th> <th>email_seller</th> </tr> ");
                while (result.next()) {
                    int id = result.getInt("id");
                    String name_seller = result.getString("name_seller");
                    String contact_seller = result.getString("contact_seller");
                    String email_seller = result.getString("email_seller");

                    out.println("<tr> <td> " + id + "</td> <td> " + name_seller + " </td> <td>" + contact_seller + "</td> <td>" + email_seller + "</td> </tr> ");
                }
                out.println("</table>");

                commandRead = "select * from Buyers";
//                Statement stat = connection.createStatement();
                result = stat.executeQuery(commandRead);

                out.println("<h1>" + "Інформація про покупців" + "</h1>");

                out.println("<table>");
                out.println("<tr> <th> id </th> <th>name_buyer</th> <th>contact_buyer</th> <th>email_buyer</th> </tr> ");
                while (result.next()) {
                    int id = result.getInt("id");
                    String name_buyer = result.getString("name_buyer");
                    String contact_buyer = result.getString("contact_buyer");
                    String email_buyer = result.getString("email_buyer");

                    out.println("<tr> <td> " + id + "</td> <td> " + name_buyer + " </td> <td>" +contact_buyer + "</td> <td>" + email_buyer + "</td> </tr> ");
                }
                out.println("</table>");

                commandRead = "select * from Products";
//                Statement stat = connection.createStatement();
                result = stat.executeQuery(commandRead);

                out.println("<h1>" + "Інформація про товари" + "</h1>");

                out.println("<table>");
                out.println("<tr> <th> id </th> <th>name_product</th> <th>count_product</th> <th>price_product</th> </tr> ");
                while (result.next()) {
                    int id = result.getInt("id");
                    String name_product = result.getString("name_product");
                    String count_product = result.getString("count_product");
                    String price_product= result.getString("price_product");

                    out.println("<tr> <td> " + id + "</td> <td> " + name_product + " </td> <td>" + count_product+ "</td> <td>" + price_product + "</td> </tr> ");
                }
                out.println("</table>");


                out.println("<h1>Завдання 3.4 Відображення інформації про угоди конкретного продавця</h1>");
                out.println("<h1>Введіть ID покупця для отримання інформації про його угоди</h1>");

                out.println("<form method='GET'>");
                out.println("ID покупця: <input type='text' name='buyer_id'><br>");
                out.println("<input type='submit' value='Вивести інформацію про вказного покупця'>");
                out.println("</form>");

                String buyerId = request.getParameter("buyer_id");
                if (buyerId != null && !buyerId.isEmpty()) {

                    String query = "SELECT Sales.id, Sellers.name_seller, Buyers.name_buyer, Products.name_product, Sales.price_sale, Sales.date_sale " +
                            "FROM Sales " +
                            "INNER JOIN Sellers ON Sales.seller_id = Sellers.id " +
                            "INNER JOIN Buyers ON Sales.buyer_id = Buyers.id " +
                            "INNER JOIN Products ON Sales.product_id = Products.id " +
                            "WHERE Buyers.id = " + buyerId;

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    out.println("<h2>Інформація про угоди покупця з ID " + buyerId + "</h2>");
                    out.println("<table>");
                    out.println("<tr><th>Номер угоди</th><th>Ім'я продавця</th><th>Ім'я покупця</th><th>Назва товару</th><th>Ціна угоди</th><th>Дата угоди</th></tr>");

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name_seller = resultSet.getString("name_seller");
                        String name_buyer = resultSet.getString("name_buyer");
                        String name_product = resultSet.getString("name_product");
                        double price_sale = resultSet.getDouble("price_sale");
                        Date date_sale = resultSet.getDate("date_sale");

                        out.println("<tr><td>" + id + "</td><td>" + name_seller + "</td><td>" + name_buyer + "</td><td>" + name_product + "</td><td>" + price_sale + "</td><td>" + date_sale + "</td></tr>");
                    }

                    out.println("</table>");
                }


                String query2 = "SELECT Sellers.id, Sellers.name_seller, SUM(Sales.price_sale) AS total_sales " +
                        "FROM Sellers " +
                        "JOIN Sales ON Sellers.id = Sales.seller_id " +
                        "GROUP BY Sellers.id, Sellers.name_seller " +
                        "ORDER BY total_sales DESC " +
                        "LIMIT 1";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query2);

                if (resultSet.next()) {
                    int sellerId = resultSet.getInt("id");
                    String sellerName = resultSet.getString("name_seller");
                    double totalSales = resultSet.getDouble("total_sales");

                    out.println("<h2>Завдання 4.1. Інформація про найбільш успішного продавця (максимальна сума продажів)</h2>");
                    out.println("<p>ID продавця: " + sellerId + "</p>");
                    out.println("<p>Ім'я продавця: " + sellerName + "</p>");
                    out.println("<p>Загальна сума продажів: " + totalSales + "</p>");
                } else {
                    out.println("<p>Немає даних про продавців у базі даних.</p>");
                }

                String query3 = "SELECT Products.id, Products.name_product, SUM(Sales.count_product) AS total_units_sold " +
                        "FROM Products " +
                        "JOIN Sales ON Products.id = Sales.product_id " +
                        "GROUP BY Products.id, Products.name_product " +
                        "ORDER BY total_units_sold DESC " +
                        "LIMIT 1";
                try (Statement statement3 = connection.createStatement();
                     ResultSet resultSet3 = statement3.executeQuery(query3)) {

                    out.println("<h2>Завдання 4.4 Інформація про найпопулярніший товар</h2>");

                    if (resultSet3.next()) {
                        int productId = resultSet3.getInt("id");
                        String productName = resultSet3.getString("name_product");
                        int totalUnitsSold = resultSet3.getInt("total_units_sold");

                        out.println("<p>ID товару: " + productId + "</p>");
                        out.println("<p>Назва товару: " + productName + "</p>");
                        out.println("<p>Загальна кількість проданих одиниць: " + totalUnitsSold + "</p>");
                    } else {
                        out.println("<p>Немає даних про товари у базі даних.</p>");
                    }




                    out.println("<h1>Вибір діапазону дат</h1>");
                    out.println("<form method='GET' action='/hello-servlet'>");
                    out.println("Початкова дата: <input type='date' name='start_date'><br>");
                    out.println("Кінцева дата: <input type='date' name='end_date'><br>");
                    out.println("<input type='submit' value='Відобразити інформацію'>");
                    out.println("</form>");

                    String startDate = request.getParameter("start_date");
                    String endDate = request.getParameter("end_date");

                    if (startDate != null && endDate != null) {
                        try {
                            String query = "SELECT * FROM Sales WHERE date_sale BETWEEN ? AND ?";
                            PreparedStatement preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setString(1, startDate);
                            preparedStatement.setString(2, endDate);
                            resultSet = preparedStatement.executeQuery();

                            out.println("<h2>Інформація про угоди за період з " + startDate + " до " + endDate + "</h2>");
                            out.println("<table>");
                            out.println("<tr><th>ID</th><th>ID продавця</th><th>ID покупця</th><th>ID товару</th><th>Ціна угоди</th><th>Дата угоди</th></tr>");

                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                int sellerId = resultSet.getInt("seller_id");
                                int buyerId2 = resultSet.getInt("buyer_id");
                                int productId = resultSet.getInt("product_id");
                                double priceSale = resultSet.getDouble("price_sale");
                                String dateSale = resultSet.getString("date_sale");

                                out.println("<tr><td>" + id + "</td><td>" + sellerId + "</td><td>" + buyerId2 + "</td><td>" + productId + "</td><td>" + priceSale + "</td><td>" + dateSale + "</td></tr>");
                            }

                            out.println("</table>");
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
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
