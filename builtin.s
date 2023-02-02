	.text
	.file	"builtin.c"
	.globl	_f_getInt0              # -- Begin function _f_getInt0
	.p2align	2
	.type	_f_getInt0,@function
_f_getInt0:                             # @_f_getInt0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	addi	a1, s0, -12
	call	scanf
	lw	a1, -12(s0)
	sw	a0, -16(s0)
	mv	a0, a1
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	_f_getInt0, .Lfunc_end0-_f_getInt0
                                        # -- End function
	.globl	_f_print0               # -- Begin function _f_print0
	.p2align	2
	.type	_f_print0,@function
_f_print0:                              # @_f_print0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	_f_print0, .Lfunc_end1-_f_print0
                                        # -- End function
	.globl	_f_println0             # -- Begin function _f_println0
	.p2align	2
	.type	_f_println0,@function
_f_println0:                            # @_f_println0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	_f_println0, .Lfunc_end2-_f_println0
                                        # -- End function
	.globl	_f_printInt0            # -- Begin function _f_printInt0
	.p2align	2
	.type	_f_printInt0,@function
_f_printInt0:                           # @_f_printInt0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end3:
	.size	_f_printInt0, .Lfunc_end3-_f_printInt0
                                        # -- End function
	.globl	_f_printlnInt0          # -- Begin function _f_printlnInt0
	.p2align	2
	.type	_f_printlnInt0,@function
_f_printlnInt0:                         # @_f_printlnInt0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	_f_printlnInt0, .Lfunc_end4-_f_printlnInt0
                                        # -- End function
	.globl	_f_toString0            # -- Begin function _f_toString0
	.p2align	2
	.type	_f_toString0,@function
_f_toString0:                           # @_f_toString0
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	addi	s0, sp, 32
	sw	a0, -12(s0)
	addi	a0, zero, 13
	call	malloc
	sw	a0, -16(s0)
	lw	a0, -16(s0)
	lw	a2, -12(s0)
	lui	a1, %hi(.L.str)
	addi	a1, a1, %lo(.L.str)
	call	sprintf
	lw	a1, -16(s0)
	sw	a0, -20(s0)
	mv	a0, a1
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end5:
	.size	_f_toString0, .Lfunc_end5-_f_toString0
                                        # -- End function
	.globl	_f_getString0           # -- Begin function _f_getString0
	.p2align	2
	.type	_f_getString0,@function
_f_getString0:                          # @_f_getString0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	addi	a0, zero, 256
	call	malloc
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	call	scanf
	lw	a1, -12(s0)
	sw	a0, -16(s0)
	mv	a0, a1
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	_f_getString0, .Lfunc_end6-_f_getString0
                                        # -- End function
	.globl	_f__malloc0             # -- Begin function _f__malloc0
	.p2align	2
	.type	_f__malloc0,@function
_f__malloc0:                            # @_f__malloc0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a0, -12(s0)
	call	malloc
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end7:
	.size	_f__malloc0, .Lfunc_end7-_f__malloc0
                                        # -- End function
	.globl	_f__str_ne0             # -- Begin function _f__str_ne0
	.p2align	2
	.type	_f__str_ne0,@function
_f__str_ne0:                            # @_f__str_ne0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	snez	a0, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end8:
	.size	_f__str_ne0, .Lfunc_end8-_f__str_ne0
                                        # -- End function
	.globl	_f__str_eq0             # -- Begin function _f__str_eq0
	.p2align	2
	.type	_f__str_eq0,@function
_f__str_eq0:                            # @_f__str_eq0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	seqz	a0, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	_f__str_eq0, .Lfunc_end9-_f__str_eq0
                                        # -- End function
	.globl	__f__str_le0            # -- Begin function __f__str_le0
	.p2align	2
	.type	__f__str_le0,@function
__f__str_le0:                           # @__f__str_le0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	slti	a0, a0, 1
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end10:
	.size	__f__str_le0, .Lfunc_end10-__f__str_le0
                                        # -- End function
	.globl	_f__str_lt0             # -- Begin function _f__str_lt0
	.p2align	2
	.type	_f__str_lt0,@function
_f__str_lt0:                            # @_f__str_lt0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	srli	a0, a0, 31
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end11:
	.size	_f__str_lt0, .Lfunc_end11-_f__str_lt0
                                        # -- End function
	.globl	_f__str_ge0             # -- Begin function _f__str_ge0
	.p2align	2
	.type	_f__str_ge0,@function
_f__str_ge0:                            # @_f__str_ge0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	_f__str_ge0, .Lfunc_end12-_f__str_ge0
                                        # -- End function
	.globl	_f__str_gt0             # -- Begin function _f__str_gt0
	.p2align	2
	.type	_f__str_gt0,@function
_f__str_gt0:                            # @_f__str_gt0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	call	strcmp
	mv	a1, zero
	slt	a0, a1, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	_f__str_gt0, .Lfunc_end13-_f__str_gt0
                                        # -- End function
	.globl	_f__str_splice0         # -- Begin function _f__str_splice0
	.p2align	2
	.type	_f__str_splice0,@function
_f__str_splice0:                        # @_f__str_splice0
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	addi	s0, sp, 32
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	call	strlen
	lw	a1, -16(s0)
	sw	a0, -24(s0)
	mv	a0, a1
	call	strlen
	lw	a1, -24(s0)
	add	a0, a1, a0
	addi	a0, a0, 1
	call	malloc
	sw	a0, -20(s0)
	lw	a0, -20(s0)
	lw	a1, -12(s0)
	call	strcpy
	lw	a1, -20(s0)
	lw	a2, -16(s0)
	sw	a0, -28(s0)
	mv	a0, a1
	mv	a1, a2
	call	strcat
	lw	a1, -20(s0)
	sw	a0, -32(s0)
	mv	a0, a1
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end14:
	.size	_f__str_splice0, .Lfunc_end14-_f__str_splice0
                                        # -- End function
	.globl	_class_string_length0   # -- Begin function _class_string_length0
	.p2align	2
	.type	_class_string_length0,@function
_class_string_length0:                  # @_class_string_length0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	lw	a0, -12(s0)
	call	strlen
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	_class_string_length0, .Lfunc_end15-_class_string_length0
                                        # -- End function
	.globl	_class_string_ord0      # -- Begin function _class_string_ord0
	.p2align	2
	.type	_class_string_ord0,@function
_class_string_ord0:                     # @_class_string_ord0
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	s0, sp, 16
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	lw	a0, -12(s0)
	lw	a1, -16(s0)
	add	a0, a0, a1
	lbu	a0, 0(a0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end16:
	.size	_class_string_ord0, .Lfunc_end16-_class_string_ord0
                                        # -- End function
	.globl	_class_string_parseInt0 # -- Begin function _class_string_parseInt0
	.p2align	2
	.type	_class_string_parseInt0,@function
_class_string_parseInt0:                # @_class_string_parseInt0
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	addi	s0, sp, 32
	sw	a0, -12(s0)
	mv	a0, zero
	sw	a0, -16(s0)
	sw	a0, -20(s0)
	j	.LBB17_1
.LBB17_1:                               # =>This Inner Loop Header: Depth=1
	lw	a0, -12(s0)
	lw	a1, -20(s0)
	add	a0, a0, a1
	lbu	a0, 0(a0)
	mv	a1, zero
	beq	a0, a1, .LBB17_3
	j	.LBB17_2
.LBB17_2:                               #   in Loop: Header=BB17_1 Depth=1
	lw	a0, -16(s0)
	addi	a1, zero, 10
	mul	a0, a0, a1
	lw	a1, -12(s0)
	lw	a2, -20(s0)
	add	a1, a1, a2
	lbu	a1, 0(a1)
	add	a0, a0, a1
	addi	a0, a0, -48
	sw	a0, -16(s0)
	lw	a0, -20(s0)
	addi	a0, a0, 1
	sw	a0, -20(s0)
	j	.LBB17_1
.LBB17_3:
	lw	a0, -16(s0)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end17:
	.size	_class_string_parseInt0, .Lfunc_end17-_class_string_parseInt0
                                        # -- End function
	.globl	_class_string_substring0 # -- Begin function _class_string_substring0
	.p2align	2
	.type	_class_string_substring0,@function
_class_string_substring0:               # @_class_string_substring0
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	addi	s0, sp, 32
	sw	a0, -12(s0)
	sw	a1, -16(s0)
	sw	a2, -20(s0)
	lw	a0, -20(s0)
	lw	a1, -16(s0)
	sub	a0, a0, a1
	addi	a0, a0, 1
	call	malloc
	sw	a0, -24(s0)
	lw	a0, -24(s0)
	lw	a1, -12(s0)
	lw	a2, -16(s0)
	add	a1, a1, a2
	lw	a3, -20(s0)
	sub	a2, a3, a2
	call	memcpy
	lw	a1, -24(s0)
	lw	a2, -20(s0)
	lw	a3, -16(s0)
	sub	a2, a2, a3
	add	a1, a1, a2
	mv	a2, zero
	sb	a2, 0(a1)
	lw	a1, -24(s0)
	sw	a0, -28(s0)
	mv	a0, a1
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end18:
	.size	_class_string_substring0, .Lfunc_end18-_class_string_substring0
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%d"
	.size	.L.str, 3

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s"
	.size	.L.str.1, 3

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%s\n"
	.size	.L.str.2, 4

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
	.addrsig
	.addrsig_sym scanf
	.addrsig_sym printf
	.addrsig_sym malloc
	.addrsig_sym sprintf
	.addrsig_sym strcmp
	.addrsig_sym strlen
	.addrsig_sym strcpy
	.addrsig_sym strcat

