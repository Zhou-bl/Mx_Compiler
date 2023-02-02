	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
.main_bb:
	addi	sp, sp, -76
	mv	s1,s0
	addi	s0, sp, 76
	mv	t0,s1
	sw	t0, -12(s0)
	mv	t0,ra
	sw	t0, -16(s0)
	call	_GLOBAL_
	lw	t1, -16(s0)
	mv	ra,t1
	li	t0,1
	sw	t0, -20(s0)
	lw	t2, -20(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	mv	a0,t1
	lw	t1, -12(s0)
	mv	s0,t1
	addi	sp, sp, 76
	ret

.for_condition_bb:
	lw	t0, -8(s0)
	sw	t0, -28(s0)
	li	t0,15000
	sw	t0, -32(s0)
	lw	t1, -32(s0)
	lw	t2, -28(s0)
	slt	t0, t1, t2
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	xori	t0, t1, 1
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	bne	t1,zero,.for_body_bb
	j	.main_bb2

.for_iter_bb:
	lw	t0, -8(s0)
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	addi	t0, t1, 1
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb

.for_body_bb:
	la	t0,b_glo
	sw	t0, -48(s0)
	lw	t1, -48(s0)
	lw	t0, 0(t1)
	sw	t0, -52(s0)
	lw	t0, -8(s0)
	sw	t0, -56(s0)
	li	t0,4
	sw	t0, -60(s0)
	lw	t1, -56(s0)
	lw	t2, -60(s0)
	mul	t0, t1, t2
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t2, -52(s0)
	add	t0, t1, t2
	sw	t0, -68(s0)
	li	t0,1
	sw	t0, -72(s0)
	lw	t1, -68(s0)
	lw	t2, -72(s0)
	sw	t2, 0(t1)
	j	.for_iter_bb

.main_bb2:
	li	t0,0
	sw	t0, -76(s0)
	lw	t2, -76(s0)
	sw	t2, -4(s0)
	j	.main_bb1

	.size	main, .-main
			 # -- End function
	.globl	_global_var_init
	.p2align	1
	.type	_global_var_init,@function
_global_var_init:
.N_bb:
	addi	sp, sp, -12
	mv	s1,s0
	addi	s0, sp, 12
	mv	t0,s1
	sw	t0, -4(s0)
	li	t0,15000
	sw	t0, -8(s0)
	la	t0,N_glo
	sw	t0, -12(s0)
	lw	t1, -12(s0)
	lw	t2, -8(s0)
	sw	t2, 0(t1)
	j	.N_bb1

.N_bb1:
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 12
	ret

	.size	_global_var_init, .-_global_var_init
			 # -- End function
	.globl	_global_var_init1
	.p2align	1
	.type	_global_var_init1,@function
_global_var_init1:
.b_bb:
	addi	sp, sp, -40
	mv	s1,s0
	addi	s0, sp, 40
	mv	t0,s1
	sw	t0, -4(s0)
	li	t0,15001
	sw	t0, -8(s0)
	li	t0,4
	sw	t0, -12(s0)
	lw	t1, -8(s0)
	lw	t2, -12(s0)
	mul	t0, t1, t2
	sw	t0, -16(s0)
	lw	t1, -16(s0)
	addi	t0, t1, 4
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -24(s0)
	call	_f__malloc
	lw	t1, -24(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -28(s0)
	li	t0,15001
	sw	t0, -32(s0)
	lw	t1, -28(s0)
	lw	t2, -32(s0)
	sw	t2, 0(t1)
	lw	t1, -28(s0)
	addi	t0, t1, 4
	sw	t0, -36(s0)
	la	t0,b_glo
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sw	t2, 0(t1)
	j	.b_bb1

.b_bb1:
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 40
	ret

	.size	_global_var_init1, .-_global_var_init1
			 # -- End function
	.globl	_global_var_init2
	.p2align	1
	.type	_global_var_init2,@function
_global_var_init2:
.resultCount_bb:
	addi	sp, sp, -12
	mv	s1,s0
	addi	s0, sp, 12
	mv	t0,s1
	sw	t0, -4(s0)
	li	t0,0
	sw	t0, -8(s0)
	la	t0,resultCount_glo
	sw	t0, -12(s0)
	lw	t1, -12(s0)
	lw	t2, -8(s0)
	sw	t2, 0(t1)
	j	.resultCount_bb1

.resultCount_bb1:
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 12
	ret

	.size	_global_var_init2, .-_global_var_init2
			 # -- End function
	.globl	_GLOBAL_
	.p2align	1
	.type	_GLOBAL_,@function
_GLOBAL_:
._GLOBAL__bb:
	addi	sp, sp, -16
	mv	s1,s0
	addi	s0, sp, 16
	mv	t0,s1
	sw	t0, -4(s0)
	mv	t0,ra
	sw	t0, -8(s0)
	call	_global_var_init
	lw	t1, -8(s0)
	mv	ra,t1
	mv	t0,ra
	sw	t0, -12(s0)
	call	_global_var_init1
	lw	t1, -12(s0)
	mv	ra,t1
	mv	t0,ra
	sw	t0, -16(s0)
	call	_global_var_init2
	lw	t1, -16(s0)
	mv	ra,t1
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 16
	ret

	.size	_GLOBAL_, .-_GLOBAL_
			 # -- End function
	.type	N_glo,@object
	.section	.bss
	.globl	N_glo
N_glo:
	.word	0
	.size	N_glo, 4
	.type	b_glo,@object
	.section	.bss
	.globl	b_glo
b_glo:
	.word	0
	.size	b_glo, 4
	.type	resultCount_glo,@object
	.section	.bss
	.globl	resultCount_glo
resultCount_glo:
	.word	0
	.size	resultCount_glo, 4

