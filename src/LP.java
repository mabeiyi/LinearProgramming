import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.GlpkException;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_prob;
import org.gnu.glpk.glp_smcp;
/*
 * Answer to question.docx
 * 
 */
public class LP {
	// max z = 300 * yin + 160 * ynb + 360 * yib
	//         + 220 * bin + 130 * bnb + 280 * bib
	//         + 100 * min + 80 * mnb + 140 * mib
	
	// subject to:
	// 0 <= yin + bin + min + yib + bib + mib <= 30
	// 0 <= ynb + bnb + mnb + yib + bib + mib <= 30
	
	// where:
	// 0 <= yin <= 4
	// 0 <= ynb <= 8
	// 0 <= yib <= 30
	// 0 <= bin <= 8
	// 0 <= bnb <= 13
	// 0 <= bib <= 10
	// 0 <= min <= 22
	// 0 <= mnb <= 20
	// 0 <= mib <= 118
	
    public static void main(String[] arg) {
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;

        try {
            // Create problem
            lp = GLPK.glp_create_prob();
            System.out.println("Problem created");
            GLPK.glp_set_prob_name(lp, "myProblem");

            // Define columns
            GLPK.glp_add_cols(lp, 9);
            GLPK.glp_set_col_name(lp, 1, "yin");
            GLPK.glp_set_col_kind(lp, 1, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_DB, 0, 4);
            GLPK.glp_set_col_name(lp, 2, "bin");
            GLPK.glp_set_col_kind(lp, 2, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_DB, 0, 8);
            GLPK.glp_set_col_name(lp, 3, "min");
            GLPK.glp_set_col_kind(lp, 3, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 3, GLPKConstants.GLP_DB, 0, 22);
            GLPK.glp_set_col_name(lp, 4, "ynb");
            GLPK.glp_set_col_kind(lp, 4, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 4, GLPKConstants.GLP_DB, 0, 8);
            GLPK.glp_set_col_name(lp, 5, "bnb");
            GLPK.glp_set_col_kind(lp, 5, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 5, GLPKConstants.GLP_DB, 0, 13);
            GLPK.glp_set_col_name(lp, 6, "mnb");
            GLPK.glp_set_col_kind(lp, 6, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 6, GLPKConstants.GLP_DB, 0, 20);
            GLPK.glp_set_col_name(lp, 7, "yib");
            GLPK.glp_set_col_kind(lp, 7, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 7, GLPKConstants.GLP_DB, 0, 3);
            GLPK.glp_set_col_name(lp, 8, "bib");
            GLPK.glp_set_col_kind(lp, 8, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 8, GLPKConstants.GLP_DB, 0, 10);
            GLPK.glp_set_col_name(lp, 9, "mib");
            GLPK.glp_set_col_kind(lp, 9, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 9, GLPKConstants.GLP_DB, 0, 118);

            // Create constraints

            // Allocate memory
            ind = GLPK.new_intArray(9);
            val = GLPK.new_doubleArray(9);

            // Create rows
            GLPK.glp_add_rows(lp, 2);

            // Set row details
            // subject to:
        	// 0 <= yin + bin + min + yib + bib + mib <= 30
        	// 0 <= ynb + bnb + mnb + yib + bib + mib <= 30
            GLPK.glp_set_row_name(lp, 1, "c1");
            GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_DB, 0, 30);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.intArray_setitem(ind, 3, 3);
            GLPK.intArray_setitem(ind, 4, 7);
            GLPK.intArray_setitem(ind, 5, 8);
            GLPK.intArray_setitem(ind, 6, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.doubleArray_setitem(val, 4, 1.);
            GLPK.doubleArray_setitem(val, 5, 1.);
            GLPK.doubleArray_setitem(val, 6, 1.);
            GLPK.glp_set_mat_row(lp, 1, 6, ind, val);

            GLPK.glp_set_row_name(lp, 2, "c2");
            GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_DB, 0, 30);
            GLPK.intArray_setitem(ind, 1, 4);
            GLPK.intArray_setitem(ind, 2, 5);
            GLPK.intArray_setitem(ind, 3, 6);
            GLPK.intArray_setitem(ind, 4, 7);
            GLPK.intArray_setitem(ind, 5, 8);
            GLPK.intArray_setitem(ind, 6, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.doubleArray_setitem(val, 4, 1.);
            GLPK.doubleArray_setitem(val, 5, 1.);
            GLPK.doubleArray_setitem(val, 6, 1.);
            GLPK.glp_set_mat_row(lp, 2, 6, ind, val);
            
            // Free memory
            GLPK.delete_intArray(ind);
            GLPK.delete_doubleArray(val);

            // Define objective
        	// max z = 300 * yin + 160 * ynb + 360 * yib
        	//         + 220 * bin + 130 * bnb + 280 * bib
        	//         + 100 * min + 80 * mnb + 140 * mib
            
            GLPK.glp_set_obj_name(lp, "z");
            GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MAX);
            GLPK.glp_set_obj_coef(lp, 1, 300);
            GLPK.glp_set_obj_coef(lp, 2, 220);
            GLPK.glp_set_obj_coef(lp, 3, 100);
            GLPK.glp_set_obj_coef(lp, 4, 160);
            GLPK.glp_set_obj_coef(lp, 5, 130);
            GLPK.glp_set_obj_coef(lp, 6, 80);
            GLPK.glp_set_obj_coef(lp, 7, 360);
            GLPK.glp_set_obj_coef(lp, 8, 280);
            GLPK.glp_set_obj_coef(lp, 9, 140);

            // Write model to file
            // GLPK.glp_write_lp(lp, null, "lp.lp");

            // Solve model
            parm = new glp_smcp();
            GLPK.glp_init_smcp(parm);
            ret = GLPK.glp_simplex(lp, parm);

            // Retrieve solution
            if (ret == 0) {
                write_lp_solution(lp);
            } else {
                System.out.println("The problem could not be solved");
            }

            // Free memory
            GLPK.glp_delete_prob(lp);
        } catch (GlpkException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * write simplex solution
     * @param lp problem
     */
    static void write_lp_solution(glp_prob lp) {
        int i;
        int n;
        String name;
        double val;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);
        for (i = 1; i <= n; i++) {
            name = GLPK.glp_get_col_name(lp, i);
            val = GLPK.glp_get_col_prim(lp, i);
            System.out.print(name);
            System.out.print(" = ");
            System.out.println(val);
        }
    }
}
