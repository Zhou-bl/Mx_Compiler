	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
.main_bb:
	addi	sp, sp, -28
	mv	s1,s0
	addi	s0, sp, 28
	mv	t0,s1
	sw	t0, -8(s0)
	mv	t0,ra
	sw	t0, -12(s0)
	call	_f_getInt
	lw	t1, -12(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -16(s0)
	la	t0,n_glo
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	sw	t2, 0(t1)
	li	t0,0
	sw	t0, -24(s0)
	lw	t2, -24(s0)
	sw	t2, -4(s0)
	j	.main_bb1

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0,t1
	lw	t1, -8(s0)
	mv	s0,t1
	addi	sp, sp, 28
	ret

	.size	main, .-main
			 # -- End function
	.globl	_f_abs
	.p2align	1
	.type	_f_abs,@function
_f_abs:
._f_abs_bb:
	addi	sp, sp, -44
	mv	s1,s0
	addi	s0, sp, 44
	mv	t0,s1
	sw	t0, -12(s0)
	sw	a0, -8(s0)
	lw	t0, -8(s0)
	sw	t0, -16(s0)
	li	t0,0
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	slt	t0, t1, t2
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	bne	t1,zero,.if_then_bb
	j	._f_abs_bb2

._f_abs_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0,t1
	lw	t1, -12(s0)
	mv	s0,t1
	addi	sp, sp, 44
	ret

.if_then_bb:
	lw	t0, -8(s0)
	sw	t0, -32(s0)
	lw	t2, -32(s0)
	sw	t2, -4(s0)
	j	._f_abs_bb1

._f_abs_bb2:
	lw	t0, -8(s0)
	sw	t0, -36(s0)
	li	t0,0
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sub	t0, t1, t2
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -4(s0)
	j	._f_abs_bb1

	.size	_f_abs, .-_f_abs
			 # -- End function
	.type	n_glo,@object
	.section	.bss
	.globl	n_glo
n_glo:
	.word	0
	.size	n_glo, 4
	.type	r_glo,@object
	.section	.bss
	.globl	r_glo
r_glo:
	.word	0
	.size	r_glo, 4
	.type	c_glo,@object
	.section	.bss
	.globl	c_glo
c_glo:
	.word	0
	.size	c_glo, 4
	.type	i_glo,@object
	.section	.bss
	.globl	i_glo
i_glo:
	.word	0
	.size	i_glo, 4
	.type	j_glo,@object
	.section	.bss
	.globl	j_glo
j_glo:
	.word	0
	.size	j_glo, 4

