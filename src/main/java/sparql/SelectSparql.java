package sparql;

/**
 * Created by matthew on 19/11/15.
 */

    public interface SelectSparql {

        public final static String PRIMARY_KEY = "primary_key";
        public final static String NO_DOMAINS = "no_domains";
        public final static String URI = "uri";
        public final static String TRUE = "1";
        public final static String FALSE = "0";

        public final static String Uoxf = "uoxf";

        public String getDefine();

        public void setDefine(String define);

        /**
         * The prefix used for all sparql.
         *
         * @return
         */
        public String getPrefix();

        /**
         * Setting the prefix.
         *
         * @param prefix
         */
        public void setPrefix(String prefix);

        /**
         * Retrieve the initial select usually used in the reader and or processor.
         *
         * @return
         */
        public String getSelect();

        /**
         * Set the select.
         *
         * @param select
         */
        public void setSelect(String select) throws SparqlException;

        /**
         * Retrieve the where clause.  Note the variables must match those in the getSelect method.
         *
         * @return
         * @throws SparqlException
         */

        public String getWhere() throws SparqlException;

        /**
         * Set the where clause.
         *
         * @param where
         */
        void setWhere(String where);

        /**
         * Get the graphs used in all sparql commands.
         *
         * @return
         */

        public String getFrom();

        /**
         * Set the graphs.
         *
         * @param graph
         */
        public void setFrom(String graph);

        /**
         * Retrieve the order by used in the original select.  If this is null it is ignored.
         *
         * @return
         */
        public String getOrderBy();

        /**
         * Set the order by.
         *
         * @param orderByStatement
         */
        public void setOrderBy(String orderByStatement);

        /**
         * Retrieve the Group by used in the original select.  If this is null it is ignored.
         *
         * @return
         */
        public String getGroupBy();

        /**
         * Set the group by.
         *
         * @param groupByStatement
         */
        public void setGroupBy(String groupByStatement);

        /**
         * Retrieve the having used in the original select.  If this is null it is ignored.
         *
         * @return
         */
        public String getHaving();

        /**
         * Set the having.
         *
         * @param havingStatement
         */
        public void setHaving(String havingStatement);


        public String getConstruct();

        public void setConstruct(String construct);


        public String getLimit();

        public void setLimit(String limit);


        public String getOffset();

        public void setOffset(String offset);

        public void setSparql(String sparql);

        /**
         * Retrieve the overall sparql constructed from all of the parts above.
         *
         * @return
         * @throws SparqlException
         */

        public String getSparql() throws SparqlException;


        /**
         * The sparqlentity is a simple Map where "value" can be retrieved based on a key.  This is mainly to represent the results of a SparqlQuery, but can be any kind of data Map.
         * The primary use of this is to enable dynamic queries based on the data stored in the SparqlEntity.
         */
        public void setSparqlEntity(SparqlEntity sparqlentity);

        /**
         * See @setSparqlEntity above
         *
         * @return SparqlEntity the current data stored and used to generate the query.
         */

        public SparqlEntity getSparqlEntity();

}
