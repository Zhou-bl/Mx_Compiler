	.text
	.globl	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	sw	s0, -4(sp)
	addi	sp, sp, -4
	addi	s0, sp, 4
	li	t6, 0
	sw	t6, -4(s0)
	j	.main_bb1

.main_bb1:
	lw	a0, -4(s0)
	addi	sp, sp, 4
	lw	s0, -4(sp)
	ret

	.size	main, .-main
			 # -- End function

