	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
.main_bb:
	addi	sp, sp, -256
	mv	s1,s0
	addi	s0, sp, 256
	mv	t0,s1
	sw	t0, -12(s0)
	mv	t0,ra
	sw	t0, -16(s0)
	call	_GLOBAL_
	lw	t1, -16(s0)
	mv	ra,t1
	mv	t0,ra
	sw	t0, -20(s0)
	call	_f_getString
	lw	t1, -20(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -28(s0)
	call	_class_string_parseInt
	lw	t1, -28(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -32(s0)
	la	t0,n_glo
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	lw	t2, -32(s0)
	sw	t2, 0(t1)
	la	t0,n_glo
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t0, 0(t1)
	sw	t0, -44(s0)
	li	t0,4
	sw	t0, -48(s0)
	lw	t1, -44(s0)
	lw	t2, -48(s0)
	mul	t0, t1, t2
	sw	t0, -52(s0)
	lw	t1, -52(s0)
	addi	t0, t1, 4
	sw	t0, -56(s0)
	lw	t1, -56(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -60(s0)
	call	_f__malloc
	lw	t1, -60(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t2, -44(s0)
	sw	t2, 0(t1)
	lw	t1, -64(s0)
	addi	t0, t1, 4
	sw	t0, -68(s0)
	la	t0,a_glo
	sw	t0, -72(s0)
	lw	t1, -72(s0)
	lw	t2, -68(s0)
	sw	t2, 0(t1)
	li	t0,0
	sw	t0, -76(s0)
	lw	t2, -76(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb1

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -80(s0)
	lw	t1, -80(s0)
	mv	a0,t1
	lw	t1, -12(s0)
	mv	s0,t1
	addi	sp, sp, 256
	ret

.for_condition_bb1:
	la	t0,a_glo
	sw	t0, -84(s0)
	lw	t1, -84(s0)
	lw	t0, 0(t1)
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	addi	t0, t1, -4
	sw	t0, -92(s0)
	lw	t1, -92(s0)
	lw	t0, 0(t1)
	sw	t0, -96(s0)
	lw	t0, -8(s0)
	sw	t0, -100(s0)
	lw	t1, -100(s0)
	lw	t2, -96(s0)
	slt	t0, t1, t2
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	bne	t1,zero,.for_body_bb1
	j	.main_bb2

.for_iter_bb1:
	lw	t0, -8(s0)
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	addi	t0, t1, 1
	sw	t0, -112(s0)
	lw	t2, -112(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb1

.for_body_bb1:
	lw	t0, -8(s0)
	sw	t0, -116(s0)
	la	t0,a_glo
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	lw	t0, 0(t1)
	sw	t0, -124(s0)
	lw	t0, -8(s0)
	sw	t0, -128(s0)
	li	t0,4
	sw	t0, -132(s0)
	lw	t1, -128(s0)
	lw	t2, -132(s0)
	mul	t0, t1, t2
	sw	t0, -136(s0)
	lw	t1, -136(s0)
	lw	t2, -124(s0)
	add	t0, t1, t2
	sw	t0, -140(s0)
	lw	t1, -140(s0)
	lw	t2, -116(s0)
	sw	t2, 0(t1)
	j	.for_iter_bb1

.main_bb2:
	mv	t0,ra
	sw	t0, -144(s0)
	call	_f_makeHeap
	lw	t1, -144(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -148(s0)
	mv	t0,ra
	sw	t0, -152(s0)
	call	_f_heapSort
	lw	t1, -152(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -156(s0)
	li	t0,0
	sw	t0, -160(s0)
	lw	t2, -160(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb2

.for_condition_bb2:
	la	t0,a_glo
	sw	t0, -164(s0)
	lw	t1, -164(s0)
	lw	t0, 0(t1)
	sw	t0, -168(s0)
	lw	t1, -168(s0)
	addi	t0, t1, -4
	sw	t0, -172(s0)
	lw	t1, -172(s0)
	lw	t0, 0(t1)
	sw	t0, -176(s0)
	lw	t0, -8(s0)
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	lw	t2, -176(s0)
	slt	t0, t1, t2
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	bne	t1,zero,.for_body_bb2
	j	.main_bb3

.for_iter_bb2:
	lw	t0, -8(s0)
	sw	t0, -188(s0)
	lw	t1, -188(s0)
	addi	t0, t1, 1
	sw	t0, -192(s0)
	lw	t2, -192(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb2

.for_body_bb2:
	la	t0,a_glo
	sw	t0, -196(s0)
	lw	t1, -196(s0)
	lw	t0, 0(t1)
	sw	t0, -200(s0)
	lw	t0, -8(s0)
	sw	t0, -204(s0)
	li	t0,4
	sw	t0, -208(s0)
	lw	t1, -204(s0)
	lw	t2, -208(s0)
	mul	t0, t1, t2
	sw	t0, -212(s0)
	lw	t1, -212(s0)
	lw	t2, -200(s0)
	add	t0, t1, t2
	sw	t0, -216(s0)
	lw	t1, -216(s0)
	lw	t0, 0(t1)
	sw	t0, -220(s0)
	lw	t1, -220(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -224(s0)
	call	_f_toString
	lw	t1, -224(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -228(s0)
	la	t0,_str
	sw	t0, -232(s0)
	lw	t1, -228(s0)
	mv	a0,t1
	lw	t1, -232(s0)
	mv	a1,t1
	mv	t0,ra
	sw	t0, -236(s0)
	call	_f__str_splice
	lw	t1, -236(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -240(s0)
	lw	t1, -240(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -244(s0)
	call	_f_print
	lw	t1, -244(s0)
	mv	ra,t1
	j	.for_iter_bb2

.main_bb3:
	la	t0,_str1
	sw	t0, -248(s0)
	lw	t1, -248(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -252(s0)
	call	_f_print
	lw	t1, -252(s0)
	mv	ra,t1
	li	t0,0
	sw	t0, -256(s0)
	lw	t2, -256(s0)
	sw	t2, -4(s0)
	j	.main_bb1

	.size	main, .-main
			 # -- End function
	.globl	_f_heapSort
	.p2align	1
	.type	_f_heapSort,@function
_f_heapSort:
._f_heapSort_bb:
	addi	sp, sp, -212
	mv	s1,s0
	addi	s0, sp, 212
	mv	t0,s1
	sw	t0, -16(s0)
	li	t0,0
	sw	t0, -20(s0)
	lw	t2, -20(s0)
	sw	t2, -8(s0)
	li	t0,0
	sw	t0, -24(s0)
	lw	t2, -24(s0)
	sw	t2, -12(s0)
	j	.for_condition_bb

._f_heapSort_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0,t1
	lw	t1, -16(s0)
	mv	s0,t1
	addi	sp, sp, 212
	ret

.for_condition_bb:
	la	t0,n_glo
	sw	t0, -32(s0)
	lw	t1, -32(s0)
	lw	t0, 0(t1)
	sw	t0, -36(s0)
	lw	t0, -12(s0)
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	slt	t0, t1, t2
	sw	t0, -44(s0)
	lw	t1, -44(s0)
	bne	t1,zero,.for_body_bb
	j	._f_heapSort_bb2

.for_iter_bb:
	lw	t0, -12(s0)
	sw	t0, -48(s0)
	lw	t1, -48(s0)
	addi	t0, t1, 1
	sw	t0, -52(s0)
	lw	t2, -52(s0)
	sw	t2, -12(s0)
	j	.for_condition_bb

.for_body_bb:
	la	t0,a_glo
	sw	t0, -56(s0)
	lw	t1, -56(s0)
	lw	t0, 0(t1)
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	addi	t0, t1, 0
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t0, 0(t1)
	sw	t0, -68(s0)
	lw	t2, -68(s0)
	sw	t2, -8(s0)
	la	t0,a_glo
	sw	t0, -72(s0)
	lw	t1, -72(s0)
	lw	t0, 0(t1)
	sw	t0, -76(s0)
	lw	t0, -12(s0)
	sw	t0, -80(s0)
	la	t0,n_glo
	sw	t0, -84(s0)
	lw	t1, -84(s0)
	lw	t0, 0(t1)
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	lw	t2, -80(s0)
	sub	t0, t1, t2
	sw	t0, -92(s0)
	li	t0,1
	sw	t0, -96(s0)
	lw	t1, -92(s0)
	lw	t2, -96(s0)
	sub	t0, t1, t2
	sw	t0, -100(s0)
	li	t0,4
	sw	t0, -104(s0)
	lw	t1, -100(s0)
	lw	t2, -104(s0)
	mul	t0, t1, t2
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	lw	t2, -76(s0)
	add	t0, t1, t2
	sw	t0, -112(s0)
	lw	t1, -112(s0)
	lw	t0, 0(t1)
	sw	t0, -116(s0)
	la	t0,a_glo
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	lw	t0, 0(t1)
	sw	t0, -124(s0)
	lw	t1, -124(s0)
	addi	t0, t1, 0
	sw	t0, -128(s0)
	lw	t1, -128(s0)
	lw	t2, -116(s0)
	sw	t2, 0(t1)
	lw	t0, -8(s0)
	sw	t0, -132(s0)
	la	t0,a_glo
	sw	t0, -136(s0)
	lw	t1, -136(s0)
	lw	t0, 0(t1)
	sw	t0, -140(s0)
	lw	t0, -12(s0)
	sw	t0, -144(s0)
	la	t0,n_glo
	sw	t0, -148(s0)
	lw	t1, -148(s0)
	lw	t0, 0(t1)
	sw	t0, -152(s0)
	lw	t1, -152(s0)
	lw	t2, -144(s0)
	sub	t0, t1, t2
	sw	t0, -156(s0)
	li	t0,1
	sw	t0, -160(s0)
	lw	t1, -156(s0)
	lw	t2, -160(s0)
	sub	t0, t1, t2
	sw	t0, -164(s0)
	li	t0,4
	sw	t0, -168(s0)
	lw	t1, -164(s0)
	lw	t2, -168(s0)
	mul	t0, t1, t2
	sw	t0, -172(s0)
	lw	t1, -172(s0)
	lw	t2, -140(s0)
	add	t0, t1, t2
	sw	t0, -176(s0)
	lw	t1, -176(s0)
	lw	t2, -132(s0)
	sw	t2, 0(t1)
	lw	t0, -12(s0)
	sw	t0, -180(s0)
	la	t0,n_glo
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	lw	t0, 0(t1)
	sw	t0, -188(s0)
	lw	t1, -188(s0)
	lw	t2, -180(s0)
	sub	t0, t1, t2
	sw	t0, -192(s0)
	li	t0,1
	sw	t0, -196(s0)
	lw	t1, -192(s0)
	lw	t2, -196(s0)
	sub	t0, t1, t2
	sw	t0, -200(s0)
	lw	t1, -200(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -204(s0)
	call	_f_adjustHeap
	lw	t1, -204(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -208(s0)
	j	.for_iter_bb

._f_heapSort_bb2:
	li	t0,0
	sw	t0, -212(s0)
	lw	t2, -212(s0)
	sw	t2, -4(s0)
	j	._f_heapSort_bb1

	.size	_f_heapSort, .-_f_heapSort
			 # -- End function
	.globl	_f_exchange
	.p2align	1
	.type	_f_exchange,@function
_f_exchange:
._f_exchange_bb:
	addi	sp, sp, -124
	mv	s1,s0
	addi	s0, sp, 124
	mv	t0,s1
	sw	t0, -16(s0)
	sw	a0, -4(s0)
	sw	a1, -8(s0)
	la	t0,a_glo
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t0, 0(t1)
	sw	t0, -24(s0)
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	li	t0,4
	sw	t0, -32(s0)
	lw	t1, -28(s0)
	lw	t2, -32(s0)
	mul	t0, t1, t2
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	lw	t2, -24(s0)
	add	t0, t1, t2
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t0, 0(t1)
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -12(s0)
	la	t0,a_glo
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
	lw	t1, -68(s0)
	lw	t0, 0(t1)
	sw	t0, -72(s0)
	la	t0,a_glo
	sw	t0, -76(s0)
	lw	t1, -76(s0)
	lw	t0, 0(t1)
	sw	t0, -80(s0)
	lw	t0, -4(s0)
	sw	t0, -84(s0)
	li	t0,4
	sw	t0, -88(s0)
	lw	t1, -84(s0)
	lw	t2, -88(s0)
	mul	t0, t1, t2
	sw	t0, -92(s0)
	lw	t1, -92(s0)
	lw	t2, -80(s0)
	add	t0, t1, t2
	sw	t0, -96(s0)
	lw	t1, -96(s0)
	lw	t2, -72(s0)
	sw	t2, 0(t1)
	lw	t0, -12(s0)
	sw	t0, -100(s0)
	la	t0,a_glo
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	lw	t0, 0(t1)
	sw	t0, -108(s0)
	lw	t0, -8(s0)
	sw	t0, -112(s0)
	li	t0,4
	sw	t0, -116(s0)
	lw	t1, -112(s0)
	lw	t2, -116(s0)
	mul	t0, t1, t2
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	lw	t2, -108(s0)
	add	t0, t1, t2
	sw	t0, -124(s0)
	lw	t1, -124(s0)
	lw	t2, -100(s0)
	sw	t2, 0(t1)
	j	._f_exchange_bb1

._f_exchange_bb1:
	lw	t1, -16(s0)
	mv	s0,t1
	addi	sp, sp, 124
	ret

	.size	_f_exchange, .-_f_exchange
			 # -- End function
	.globl	_f_adjustHeap
	.p2align	1
	.type	_f_adjustHeap,@function
_f_adjustHeap:
._f_adjustHeap_bb:
	addi	sp, sp, -380
	mv	s1,s0
	addi	s0, sp, 380
	mv	t0,s1
	sw	t0, -32(s0)
	sw	a0, -8(s0)
	li	t0,0
	sw	t0, -36(s0)
	lw	t2, -36(s0)
	sw	t2, -12(s0)
	li	t0,0
	sw	t0, -40(s0)
	lw	t2, -40(s0)
	sw	t2, -16(s0)
	li	t0,0
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -20(s0)
	j	.while_condition_bb1

._f_adjustHeap_bb1:
	lw	t0, -4(s0)
	sw	t0, -48(s0)
	lw	t1, -48(s0)
	mv	a0,t1
	lw	t1, -32(s0)
	mv	s0,t1
	addi	sp, sp, 380
	ret

.while_condition_bb1:
	lw	t0, -8(s0)
	sw	t0, -52(s0)
	lw	t0, -12(s0)
	sw	t0, -56(s0)
	li	t0,2
	sw	t0, -60(s0)
	lw	t1, -56(s0)
	lw	t2, -60(s0)
	mul	t0, t1, t2
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t2, -52(s0)
	slt	t0, t1, t2
	sw	t0, -68(s0)
	lw	t1, -68(s0)
	bne	t1,zero,.while_body_bb1
	j	._f_adjustHeap_bb2

.while_body_bb1:
	lw	t0, -12(s0)
	sw	t0, -72(s0)
	li	t0,2
	sw	t0, -76(s0)
	lw	t1, -72(s0)
	lw	t2, -76(s0)
	mul	t0, t1, t2
	sw	t0, -80(s0)
	lw	t2, -80(s0)
	sw	t2, -16(s0)
	lw	t0, -8(s0)
	sw	t0, -84(s0)
	lw	t0, -12(s0)
	sw	t0, -88(s0)
	li	t0,2
	sw	t0, -92(s0)
	lw	t1, -88(s0)
	lw	t2, -92(s0)
	mul	t0, t1, t2
	sw	t0, -96(s0)
	lw	t1, -96(s0)
	addi	t0, t1, 1
	sw	t0, -100(s0)
	lw	t1, -100(s0)
	lw	t2, -84(s0)
	slt	t0, t1, t2
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	bne	t1,zero,._sBlock_bb1
	j	._dBlock_bb1

._f_adjustHeap_bb2:
	li	t0,0
	sw	t0, -108(s0)
	lw	t2, -108(s0)
	sw	t2, -4(s0)
	j	._f_adjustHeap_bb1

.if_then_bb2:
	lw	t0, -12(s0)
	sw	t0, -112(s0)
	li	t0,2
	sw	t0, -116(s0)
	lw	t1, -112(s0)
	lw	t2, -116(s0)
	mul	t0, t1, t2
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	addi	t0, t1, 1
	sw	t0, -124(s0)
	lw	t2, -124(s0)
	sw	t2, -16(s0)
	j	._f_adjustHeap_bb3

._f_adjustHeap_bb3:
	la	t0,a_glo
	sw	t0, -128(s0)
	lw	t1, -128(s0)
	lw	t0, 0(t1)
	sw	t0, -132(s0)
	lw	t0, -16(s0)
	sw	t0, -136(s0)
	li	t0,4
	sw	t0, -140(s0)
	lw	t1, -136(s0)
	lw	t2, -140(s0)
	mul	t0, t1, t2
	sw	t0, -144(s0)
	lw	t1, -144(s0)
	lw	t2, -132(s0)
	add	t0, t1, t2
	sw	t0, -148(s0)
	lw	t1, -148(s0)
	lw	t0, 0(t1)
	sw	t0, -152(s0)
	la	t0,a_glo
	sw	t0, -156(s0)
	lw	t1, -156(s0)
	lw	t0, 0(t1)
	sw	t0, -160(s0)
	lw	t0, -12(s0)
	sw	t0, -164(s0)
	li	t0,4
	sw	t0, -168(s0)
	lw	t1, -164(s0)
	lw	t2, -168(s0)
	mul	t0, t1, t2
	sw	t0, -172(s0)
	lw	t1, -172(s0)
	lw	t2, -160(s0)
	add	t0, t1, t2
	sw	t0, -176(s0)
	lw	t1, -176(s0)
	lw	t0, 0(t1)
	sw	t0, -180(s0)
	lw	t1, -152(s0)
	lw	t2, -180(s0)
	slt	t0, t1, t2
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	bne	t1,zero,.if_then_bb3
	j	.if_else_bb

._dBlock_bb1:
	lw	t2, -104(s0)
	sw	t2, -24(s0)
	j	._tBlock_bb1

._sBlock_bb1:
	la	t0,a_glo
	sw	t0, -188(s0)
	lw	t1, -188(s0)
	lw	t0, 0(t1)
	sw	t0, -192(s0)
	lw	t0, -12(s0)
	sw	t0, -196(s0)
	li	t0,2
	sw	t0, -200(s0)
	lw	t1, -196(s0)
	lw	t2, -200(s0)
	mul	t0, t1, t2
	sw	t0, -204(s0)
	li	t0,4
	sw	t0, -208(s0)
	lw	t1, -204(s0)
	lw	t2, -208(s0)
	mul	t0, t1, t2
	sw	t0, -212(s0)
	lw	t1, -212(s0)
	lw	t2, -192(s0)
	add	t0, t1, t2
	sw	t0, -216(s0)
	lw	t1, -216(s0)
	lw	t0, 0(t1)
	sw	t0, -220(s0)
	la	t0,a_glo
	sw	t0, -224(s0)
	lw	t1, -224(s0)
	lw	t0, 0(t1)
	sw	t0, -228(s0)
	lw	t0, -12(s0)
	sw	t0, -232(s0)
	li	t0,2
	sw	t0, -236(s0)
	lw	t1, -232(s0)
	lw	t2, -236(s0)
	mul	t0, t1, t2
	sw	t0, -240(s0)
	lw	t1, -240(s0)
	addi	t0, t1, 1
	sw	t0, -244(s0)
	li	t0,4
	sw	t0, -248(s0)
	lw	t1, -244(s0)
	lw	t2, -248(s0)
	mul	t0, t1, t2
	sw	t0, -252(s0)
	lw	t1, -252(s0)
	lw	t2, -228(s0)
	add	t0, t1, t2
	sw	t0, -256(s0)
	lw	t1, -256(s0)
	lw	t0, 0(t1)
	sw	t0, -260(s0)
	lw	t1, -260(s0)
	lw	t2, -220(s0)
	slt	t0, t1, t2
	sw	t0, -264(s0)
	lw	t2, -264(s0)
	sw	t2, -24(s0)
	j	._tBlock_bb1

._tBlock_bb1:
	lw	t0, -24(s0)
	sw	t0, -268(s0)
	lw	t1, -268(s0)
	bne	t1,zero,.if_then_bb2
	j	._f_adjustHeap_bb3

.if_then_bb3:
	la	t0,a_glo
	sw	t0, -272(s0)
	lw	t1, -272(s0)
	lw	t0, 0(t1)
	sw	t0, -276(s0)
	lw	t0, -12(s0)
	sw	t0, -280(s0)
	li	t0,4
	sw	t0, -284(s0)
	lw	t1, -280(s0)
	lw	t2, -284(s0)
	mul	t0, t1, t2
	sw	t0, -288(s0)
	lw	t1, -288(s0)
	lw	t2, -276(s0)
	add	t0, t1, t2
	sw	t0, -292(s0)
	lw	t1, -292(s0)
	lw	t0, 0(t1)
	sw	t0, -296(s0)
	lw	t2, -296(s0)
	sw	t2, -28(s0)
	la	t0,a_glo
	sw	t0, -300(s0)
	lw	t1, -300(s0)
	lw	t0, 0(t1)
	sw	t0, -304(s0)
	lw	t0, -16(s0)
	sw	t0, -308(s0)
	li	t0,4
	sw	t0, -312(s0)
	lw	t1, -308(s0)
	lw	t2, -312(s0)
	mul	t0, t1, t2
	sw	t0, -316(s0)
	lw	t1, -316(s0)
	lw	t2, -304(s0)
	add	t0, t1, t2
	sw	t0, -320(s0)
	lw	t1, -320(s0)
	lw	t0, 0(t1)
	sw	t0, -324(s0)
	la	t0,a_glo
	sw	t0, -328(s0)
	lw	t1, -328(s0)
	lw	t0, 0(t1)
	sw	t0, -332(s0)
	lw	t0, -12(s0)
	sw	t0, -336(s0)
	li	t0,4
	sw	t0, -340(s0)
	lw	t1, -336(s0)
	lw	t2, -340(s0)
	mul	t0, t1, t2
	sw	t0, -344(s0)
	lw	t1, -344(s0)
	lw	t2, -332(s0)
	add	t0, t1, t2
	sw	t0, -348(s0)
	lw	t1, -348(s0)
	lw	t2, -324(s0)
	sw	t2, 0(t1)
	lw	t0, -28(s0)
	sw	t0, -352(s0)
	la	t0,a_glo
	sw	t0, -356(s0)
	lw	t1, -356(s0)
	lw	t0, 0(t1)
	sw	t0, -360(s0)
	lw	t0, -16(s0)
	sw	t0, -364(s0)
	li	t0,4
	sw	t0, -368(s0)
	lw	t1, -364(s0)
	lw	t2, -368(s0)
	mul	t0, t1, t2
	sw	t0, -372(s0)
	lw	t1, -372(s0)
	lw	t2, -360(s0)
	add	t0, t1, t2
	sw	t0, -376(s0)
	lw	t1, -376(s0)
	lw	t2, -352(s0)
	sw	t2, 0(t1)
	lw	t0, -16(s0)
	sw	t0, -380(s0)
	lw	t2, -380(s0)
	sw	t2, -12(s0)
	j	._f_adjustHeap_bb4

._f_adjustHeap_bb4:
	j	.while_condition_bb1

.if_else_bb:
	j	._f_adjustHeap_bb2

	.size	_f_adjustHeap, .-_f_adjustHeap
			 # -- End function
	.globl	_f_makeHeap
	.p2align	1
	.type	_f_makeHeap,@function
_f_makeHeap:
._f_makeHeap_bb:
	addi	sp, sp, -300
	mv	s1,s0
	addi	s0, sp, 300
	mv	t0,s1
	sw	t0, -24(s0)
	la	t0,n_glo
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	lw	t0, 0(t1)
	sw	t0, -32(s0)
	li	t0,1
	sw	t0, -36(s0)
	lw	t1, -32(s0)
	lw	t2, -36(s0)
	sub	t0, t1, t2
	sw	t0, -40(s0)
	li	t0,2
	sw	t0, -44(s0)
	lw	t1, -40(s0)
	lw	t2, -44(s0)
	div	t0, t1, t2
	sw	t0, -48(s0)
	lw	t2, -48(s0)
	sw	t2, -8(s0)
	li	t0,0
	sw	t0, -52(s0)
	lw	t2, -52(s0)
	sw	t2, -12(s0)
	li	t0,0
	sw	t0, -56(s0)
	lw	t2, -56(s0)
	sw	t2, -16(s0)
	j	.while_condition_bb

._f_makeHeap_bb1:
	lw	t0, -4(s0)
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	mv	a0,t1
	lw	t1, -24(s0)
	mv	s0,t1
	addi	sp, sp, 300
	ret

.while_condition_bb:
	lw	t0, -8(s0)
	sw	t0, -64(s0)
	li	t0,0
	sw	t0, -68(s0)
	lw	t1, -64(s0)
	lw	t2, -68(s0)
	slt	t0, t1, t2
	sw	t0, -72(s0)
	lw	t1, -72(s0)
	xori	t0, t1, 1
	sw	t0, -72(s0)
	lw	t1, -72(s0)
	bne	t1,zero,.while_body_bb
	j	._f_makeHeap_bb2

.while_body_bb:
	lw	t0, -8(s0)
	sw	t0, -76(s0)
	li	t0,2
	sw	t0, -80(s0)
	lw	t1, -76(s0)
	lw	t2, -80(s0)
	mul	t0, t1, t2
	sw	t0, -84(s0)
	lw	t2, -84(s0)
	sw	t2, -16(s0)
	la	t0,n_glo
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	lw	t0, 0(t1)
	sw	t0, -92(s0)
	lw	t0, -8(s0)
	sw	t0, -96(s0)
	li	t0,2
	sw	t0, -100(s0)
	lw	t1, -96(s0)
	lw	t2, -100(s0)
	mul	t0, t1, t2
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	addi	t0, t1, 1
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	lw	t2, -92(s0)
	slt	t0, t1, t2
	sw	t0, -112(s0)
	lw	t1, -112(s0)
	bne	t1,zero,._sBlock_bb
	j	._dBlock_bb

._f_makeHeap_bb2:
	li	t0,0
	sw	t0, -116(s0)
	lw	t2, -116(s0)
	sw	t2, -4(s0)
	j	._f_makeHeap_bb1

.if_then_bb:
	lw	t0, -8(s0)
	sw	t0, -120(s0)
	li	t0,2
	sw	t0, -124(s0)
	lw	t1, -120(s0)
	lw	t2, -124(s0)
	mul	t0, t1, t2
	sw	t0, -128(s0)
	lw	t1, -128(s0)
	addi	t0, t1, 1
	sw	t0, -132(s0)
	lw	t2, -132(s0)
	sw	t2, -16(s0)
	j	._f_makeHeap_bb3

._f_makeHeap_bb3:
	la	t0,a_glo
	sw	t0, -136(s0)
	lw	t1, -136(s0)
	lw	t0, 0(t1)
	sw	t0, -140(s0)
	lw	t0, -16(s0)
	sw	t0, -144(s0)
	li	t0,4
	sw	t0, -148(s0)
	lw	t1, -144(s0)
	lw	t2, -148(s0)
	mul	t0, t1, t2
	sw	t0, -152(s0)
	lw	t1, -152(s0)
	lw	t2, -140(s0)
	add	t0, t1, t2
	sw	t0, -156(s0)
	lw	t1, -156(s0)
	lw	t0, 0(t1)
	sw	t0, -160(s0)
	la	t0,a_glo
	sw	t0, -164(s0)
	lw	t1, -164(s0)
	lw	t0, 0(t1)
	sw	t0, -168(s0)
	lw	t0, -8(s0)
	sw	t0, -172(s0)
	li	t0,4
	sw	t0, -176(s0)
	lw	t1, -172(s0)
	lw	t2, -176(s0)
	mul	t0, t1, t2
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	lw	t2, -168(s0)
	add	t0, t1, t2
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	lw	t0, 0(t1)
	sw	t0, -188(s0)
	lw	t1, -160(s0)
	lw	t2, -188(s0)
	slt	t0, t1, t2
	sw	t0, -192(s0)
	lw	t1, -192(s0)
	bne	t1,zero,.if_then_bb1
	j	._f_makeHeap_bb4

._dBlock_bb:
	lw	t2, -112(s0)
	sw	t2, -20(s0)
	j	._tBlock_bb

._sBlock_bb:
	la	t0,a_glo
	sw	t0, -196(s0)
	lw	t1, -196(s0)
	lw	t0, 0(t1)
	sw	t0, -200(s0)
	lw	t0, -8(s0)
	sw	t0, -204(s0)
	li	t0,2
	sw	t0, -208(s0)
	lw	t1, -204(s0)
	lw	t2, -208(s0)
	mul	t0, t1, t2
	sw	t0, -212(s0)
	li	t0,4
	sw	t0, -216(s0)
	lw	t1, -212(s0)
	lw	t2, -216(s0)
	mul	t0, t1, t2
	sw	t0, -220(s0)
	lw	t1, -220(s0)
	lw	t2, -200(s0)
	add	t0, t1, t2
	sw	t0, -224(s0)
	lw	t1, -224(s0)
	lw	t0, 0(t1)
	sw	t0, -228(s0)
	la	t0,a_glo
	sw	t0, -232(s0)
	lw	t1, -232(s0)
	lw	t0, 0(t1)
	sw	t0, -236(s0)
	lw	t0, -8(s0)
	sw	t0, -240(s0)
	li	t0,2
	sw	t0, -244(s0)
	lw	t1, -240(s0)
	lw	t2, -244(s0)
	mul	t0, t1, t2
	sw	t0, -248(s0)
	lw	t1, -248(s0)
	addi	t0, t1, 1
	sw	t0, -252(s0)
	li	t0,4
	sw	t0, -256(s0)
	lw	t1, -252(s0)
	lw	t2, -256(s0)
	mul	t0, t1, t2
	sw	t0, -260(s0)
	lw	t1, -260(s0)
	lw	t2, -236(s0)
	add	t0, t1, t2
	sw	t0, -264(s0)
	lw	t1, -264(s0)
	lw	t0, 0(t1)
	sw	t0, -268(s0)
	lw	t1, -268(s0)
	lw	t2, -228(s0)
	slt	t0, t1, t2
	sw	t0, -272(s0)
	lw	t2, -272(s0)
	sw	t2, -20(s0)
	j	._tBlock_bb

._tBlock_bb:
	lw	t0, -20(s0)
	sw	t0, -276(s0)
	lw	t1, -276(s0)
	bne	t1,zero,.if_then_bb
	j	._f_makeHeap_bb3

.if_then_bb1:
	lw	t0, -8(s0)
	sw	t0, -280(s0)
	lw	t0, -16(s0)
	sw	t0, -284(s0)
	lw	t1, -280(s0)
	mv	a0,t1
	lw	t1, -284(s0)
	mv	a1,t1
	mv	t0,ra
	sw	t0, -288(s0)
	call	_f_exchange
	lw	t1, -288(s0)
	mv	ra,t1
	j	._f_makeHeap_bb4

._f_makeHeap_bb4:
	lw	t0, -8(s0)
	sw	t0, -292(s0)
	li	t0,1
	sw	t0, -296(s0)
	lw	t1, -292(s0)
	lw	t2, -296(s0)
	sub	t0, t1, t2
	sw	t0, -300(s0)
	lw	t2, -300(s0)
	sw	t2, -8(s0)
	j	.while_condition_bb

	.size	_f_makeHeap, .-_f_makeHeap
			 # -- End function
	.globl	_global_var_init
	.p2align	1
	.type	_global_var_init,@function
_global_var_init:
.a_bb:
	addi	sp, sp, -12
	mv	s1,s0
	addi	s0, sp, 12
	mv	t0,s1
	sw	t0, -4(s0)
	li	t0,0
	sw	t0, -8(s0)
	la	t0,a_glo
	sw	t0, -12(s0)
	lw	t1, -12(s0)
	lw	t2, -8(s0)
	sw	t2, 0(t1)
	j	.a_bb1

.a_bb1:
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 12
	ret

	.size	_global_var_init, .-_global_var_init
			 # -- End function
	.globl	_GLOBAL_
	.p2align	1
	.type	_GLOBAL_,@function
_GLOBAL_:
._GLOBAL__bb:
	addi	sp, sp, -8
	mv	s1,s0
	addi	s0, sp, 8
	mv	t0,s1
	sw	t0, -4(s0)
	mv	t0,ra
	sw	t0, -8(s0)
	call	_global_var_init
	lw	t1, -8(s0)
	mv	ra,t1
	lw	t1, -4(s0)
	mv	s0,t1
	addi	sp, sp, 8
	ret

	.size	_GLOBAL_, .-_GLOBAL_
			 # -- End function
	.type	_str,@object
	.section	.rodata
_str:
	.asciz	" "
	.size	_str, 2
	.type	_str1,@object
	.section	.rodata
_str1:
	.asciz	"\n"
	.size	_str1, 2
	.type	n_glo,@object
	.section	.bss
	.globl	n_glo
n_glo:
	.word	0
	.size	n_glo, 4
	.type	a_glo,@object
	.section	.bss
	.globl	a_glo
a_glo:
	.word	0
	.size	a_glo, 4

