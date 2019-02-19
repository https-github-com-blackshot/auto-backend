package kz.blackshot.auto.configuration;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class CustomMySQLDialect extends MySQL5Dialect {

    public CustomMySQLDialect(){

        super();

        registerFunction(
                "group_concat",
                new StandardSQLFunction(
                        "group_contact",
                        StandardBasicTypes.STRING
                )
        );

        registerFunction(
                "year",
                new StandardSQLFunction(
                        "year",
                        StandardBasicTypes.STRING
                )
        );

    }

}
