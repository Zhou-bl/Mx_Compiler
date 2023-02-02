package Utils;

public class BuiltinPrinter {
    public String builtinCode = "\t.text\n" +
            "\t.file\t\"builtin.c\"\n" +
            "\t.globl\t_f_getInt0              # -- Begin function _f_getInt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_getInt0,@function\n" +
            "_f_getInt0:                             # @_f_getInt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tlui\ta0, %hi(.L.str)\n" +
            "\taddi\ta0, a0, %lo(.L.str)\n" +
            "\taddi\ta1, s0, -12\n" +
            "\tcall\tscanf\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tsw\ta0, -16(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end0:\n" +
            "\t.size\t_f_getInt0, .Lfunc_end0-_f_getInt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_print0               # -- Begin function _f_print0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_print0,@function\n" +
            "_f_print0:                              # @_f_print0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlui\ta0, %hi(.L.str.1)\n" +
            "\taddi\ta0, a0, %lo(.L.str.1)\n" +
            "\tcall\tprintf\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end1:\n" +
            "\t.size\t_f_print0, .Lfunc_end1-_f_print0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_println0             # -- Begin function _f_println0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_println0,@function\n" +
            "_f_println0:                            # @_f_println0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlui\ta0, %hi(.L.str.2)\n" +
            "\taddi\ta0, a0, %lo(.L.str.2)\n" +
            "\tcall\tprintf\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end2:\n" +
            "\t.size\t_f_println0, .Lfunc_end2-_f_println0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_printInt0            # -- Begin function _f_printInt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_printInt0,@function\n" +
            "_f_printInt0:                           # @_f_printInt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlui\ta0, %hi(.L.str)\n" +
            "\taddi\ta0, a0, %lo(.L.str)\n" +
            "\tcall\tprintf\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end3:\n" +
            "\t.size\t_f_printInt0, .Lfunc_end3-_f_printInt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_printlnInt0          # -- Begin function _f_printlnInt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_printlnInt0,@function\n" +
            "_f_printlnInt0:                         # @_f_printlnInt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlui\ta0, %hi(.L.str.3)\n" +
            "\taddi\ta0, a0, %lo(.L.str.3)\n" +
            "\tcall\tprintf\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end4:\n" +
            "\t.size\t_f_printlnInt0, .Lfunc_end4-_f_printlnInt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_toString0            # -- Begin function _f_toString0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_toString0,@function\n" +
            "_f_toString0:                           # @_f_toString0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\taddi\ts0, sp, 32\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\taddi\ta0, zero, 13\n" +
            "\tcall\tmalloc\n" +
            "\tsw\ta0, -16(s0)\n" +
            "\tlw\ta0, -16(s0)\n" +
            "\tlw\ta2, -12(s0)\n" +
            "\tlui\ta1, %hi(.L.str)\n" +
            "\taddi\ta1, a1, %lo(.L.str)\n" +
            "\tcall\tsprintf\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tsw\ta0, -20(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\tret\n" +
            ".Lfunc_end5:\n" +
            "\t.size\t_f_toString0, .Lfunc_end5-_f_toString0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f_getString0           # -- Begin function _f_getString0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f_getString0,@function\n" +
            "_f_getString0:                          # @_f_getString0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\taddi\ta0, zero, 256\n" +
            "\tcall\tmalloc\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlui\ta0, %hi(.L.str.1)\n" +
            "\taddi\ta0, a0, %lo(.L.str.1)\n" +
            "\tcall\tscanf\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tsw\ta0, -16(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end6:\n" +
            "\t.size\t_f_getString0, .Lfunc_end6-_f_getString0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__malloc0             # -- Begin function _f__malloc0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__malloc0,@function\n" +
            "_f__malloc0:                            # @_f__malloc0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tcall\tmalloc\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end7:\n" +
            "\t.size\t_f__malloc0, .Lfunc_end7-_f__malloc0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_ne0             # -- Begin function _f__str_ne0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_ne0,@function\n" +
            "_f__str_ne0:                            # @_f__str_ne0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tsnez\ta0, a0\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end8:\n" +
            "\t.size\t_f__str_ne0, .Lfunc_end8-_f__str_ne0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_eq0             # -- Begin function _f__str_eq0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_eq0,@function\n" +
            "_f__str_eq0:                            # @_f__str_eq0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tseqz\ta0, a0\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end9:\n" +
            "\t.size\t_f__str_eq0, .Lfunc_end9-_f__str_eq0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t__f__str_le0            # -- Begin function __f__str_le0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t__f__str_le0,@function\n" +
            "__f__str_le0:                           # @__f__str_le0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tslti\ta0, a0, 1\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end10:\n" +
            "\t.size\t__f__str_le0, .Lfunc_end10-__f__str_le0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_lt0             # -- Begin function _f__str_lt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_lt0,@function\n" +
            "_f__str_lt0:                            # @_f__str_lt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tsrli\ta0, a0, 31\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end11:\n" +
            "\t.size\t_f__str_lt0, .Lfunc_end11-_f__str_lt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_ge0             # -- Begin function _f__str_ge0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_ge0,@function\n" +
            "_f__str_ge0:                            # @_f__str_ge0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tnot\ta0, a0\n" +
            "\tsrli\ta0, a0, 31\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end12:\n" +
            "\t.size\t_f__str_ge0, .Lfunc_end12-_f__str_ge0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_gt0             # -- Begin function _f__str_gt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_gt0,@function\n" +
            "_f__str_gt0:                            # @_f__str_gt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tcall\tstrcmp\n" +
            "\tmv\ta1, zero\n" +
            "\tslt\ta0, a1, a0\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end13:\n" +
            "\t.size\t_f__str_gt0, .Lfunc_end13-_f__str_gt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_f__str_splice0         # -- Begin function _f__str_splice0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_f__str_splice0,@function\n" +
            "_f__str_splice0:                        # @_f__str_splice0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\taddi\ts0, sp, 32\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tcall\tstrlen\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tsw\ta0, -24(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tcall\tstrlen\n" +
            "\tlw\ta1, -24(s0)\n" +
            "\tadd\ta0, a1, a0\n" +
            "\taddi\ta0, a0, 1\n" +
            "\tcall\tmalloc\n" +
            "\tsw\ta0, -20(s0)\n" +
            "\tlw\ta0, -20(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tcall\tstrcpy\n" +
            "\tlw\ta1, -20(s0)\n" +
            "\tlw\ta2, -16(s0)\n" +
            "\tsw\ta0, -28(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tmv\ta1, a2\n" +
            "\tcall\tstrcat\n" +
            "\tlw\ta1, -20(s0)\n" +
            "\tsw\ta0, -32(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\tret\n" +
            ".Lfunc_end14:\n" +
            "\t.size\t_f__str_splice0, .Lfunc_end14-_f__str_splice0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_class_string_length0   # -- Begin function _class_string_length0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_class_string_length0,@function\n" +
            "_class_string_length0:                  # @_class_string_length0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tcall\tstrlen\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end15:\n" +
            "\t.size\t_class_string_length0, .Lfunc_end15-_class_string_length0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_class_string_ord0      # -- Begin function _class_string_ord0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_class_string_ord0,@function\n" +
            "_class_string_ord0:                     # @_class_string_ord0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\taddi\ts0, sp, 16\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tadd\ta0, a0, a1\n" +
            "\tlbu\ta0, 0(a0)\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end16:\n" +
            "\t.size\t_class_string_ord0, .Lfunc_end16-_class_string_ord0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_class_string_parseInt0 # -- Begin function _class_string_parseInt0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_class_string_parseInt0,@function\n" +
            "_class_string_parseInt0:                # @_class_string_parseInt0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\taddi\ts0, sp, 32\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tmv\ta0, zero\n" +
            "\tsw\ta0, -16(s0)\n" +
            "\tsw\ta0, -20(s0)\n" +
            "\tj\t.LBB17_1\n" +
            ".LBB17_1:                               # =>This Inner Loop Header: Depth=1\n" +
            "\tlw\ta0, -12(s0)\n" +
            "\tlw\ta1, -20(s0)\n" +
            "\tadd\ta0, a0, a1\n" +
            "\tlbu\ta0, 0(a0)\n" +
            "\tmv\ta1, zero\n" +
            "\tbeq\ta0, a1, .LBB17_3\n" +
            "\tj\t.LBB17_2\n" +
            ".LBB17_2:                               #   in Loop: Header=BB17_1 Depth=1\n" +
            "\tlw\ta0, -16(s0)\n" +
            "\taddi\ta1, zero, 10\n" +
            "\tmul\ta0, a0, a1\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlw\ta2, -20(s0)\n" +
            "\tadd\ta1, a1, a2\n" +
            "\tlbu\ta1, 0(a1)\n" +
            "\tadd\ta0, a0, a1\n" +
            "\taddi\ta0, a0, -48\n" +
            "\tsw\ta0, -16(s0)\n" +
            "\tlw\ta0, -20(s0)\n" +
            "\taddi\ta0, a0, 1\n" +
            "\tsw\ta0, -20(s0)\n" +
            "\tj\t.LBB17_1\n" +
            ".LBB17_3:\n" +
            "\tlw\ta0, -16(s0)\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\tret\n" +
            ".Lfunc_end17:\n" +
            "\t.size\t_class_string_parseInt0, .Lfunc_end17-_class_string_parseInt0\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_class_string_substring0 # -- Begin function _class_string_substring0\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_class_string_substring0,@function\n" +
            "_class_string_substring0:               # @_class_string_substring0\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\taddi\ts0, sp, 32\n" +
            "\tsw\ta0, -12(s0)\n" +
            "\tsw\ta1, -16(s0)\n" +
            "\tsw\ta2, -20(s0)\n" +
            "\tlw\ta0, -20(s0)\n" +
            "\tlw\ta1, -16(s0)\n" +
            "\tsub\ta0, a0, a1\n" +
            "\taddi\ta0, a0, 1\n" +
            "\tcall\tmalloc\n" +
            "\tsw\ta0, -24(s0)\n" +
            "\tlw\ta0, -24(s0)\n" +
            "\tlw\ta1, -12(s0)\n" +
            "\tlw\ta2, -16(s0)\n" +
            "\tadd\ta1, a1, a2\n" +
            "\tlw\ta3, -20(s0)\n" +
            "\tsub\ta2, a3, a2\n" +
            "\tcall\tmemcpy\n" +
            "\tlw\ta1, -24(s0)\n" +
            "\tlw\ta2, -20(s0)\n" +
            "\tlw\ta3, -16(s0)\n" +
            "\tsub\ta2, a2, a3\n" +
            "\tadd\ta1, a1, a2\n" +
            "\tmv\ta2, zero\n" +
            "\tsb\ta2, 0(a1)\n" +
            "\tlw\ta1, -24(s0)\n" +
            "\tsw\ta0, -28(s0)\n" +
            "\tmv\ta0, a1\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\tret\n" +
            ".Lfunc_end18:\n" +
            "\t.size\t_class_string_substring0, .Lfunc_end18-_class_string_substring0\n" +
            "                                        # -- End function\n" +
            "\t.type\t.L.str,@object          # @.str\n" +
            "\t.section\t.rodata.str1.1,\"aMS\",@progbits,1\n" +
            ".L.str:\n" +
            "\t.asciz\t\"%d\"\n" +
            "\t.size\t.L.str, 3\n" +
            "\n" +
            "\t.type\t.L.str.1,@object        # @.str.1\n" +
            ".L.str.1:\n" +
            "\t.asciz\t\"%s\"\n" +
            "\t.size\t.L.str.1, 3\n" +
            "\n" +
            "\t.type\t.L.str.2,@object        # @.str.2\n" +
            ".L.str.2:\n" +
            "\t.asciz\t\"%s\\n\"\n" +
            "\t.size\t.L.str.2, 4\n" +
            "\n" +
            "\t.type\t.L.str.3,@object        # @.str.3\n" +
            ".L.str.3:\n" +
            "\t.asciz\t\"%d\\n\"\n" +
            "\t.size\t.L.str.3, 4\n" +
            "\n" +
            "\t.ident\t\"clang version 10.0.0-4ubuntu1 \"\n" +
            "\t.section\t\".note.GNU-stack\",\"\",@progbits\n" +
            "\t.addrsig\n" +
            "\t.addrsig_sym scanf\n" +
            "\t.addrsig_sym printf\n" +
            "\t.addrsig_sym malloc\n" +
            "\t.addrsig_sym sprintf\n" +
            "\t.addrsig_sym strcmp\n" +
            "\t.addrsig_sym strlen\n" +
            "\t.addrsig_sym strcpy\n" +
            "\t.addrsig_sym strcat\n";
}
