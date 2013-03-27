;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE

facto: 


;ouvbloc 2
enter 2,0

;iconst 0
push word ptr 0


;istore -2
pop ax 
mov word ptr [bp-2], ax


;iload 4
push word ptr [bp+4]


;iconst 1
push word ptr 1


;iegal
pop bx 
pop ax 
cmp ax,bx 
jne $+6 
push -1 
jmp $+4 
push 0 


;iffaux SINON1
pop ax
cmp ax,0
je SINON1


;iconst 1
push word ptr 1


;ireturn 6
pop ax
mov [bp+6], ax


;goto FSI1
jmp FSI1


SINON1:


;iload -2
push word ptr [bp-2]


;iconst 1
push word ptr 1


;iadd
pop bx 
pop ax 
add ax,bx
push ax


;istore -2
pop ax 
mov word ptr [bp-2], ax


;iload 4
push word ptr [bp+4]


;reserveRetour
sub sp,2


;iload 4
push word ptr [bp+4]


;iconst 1
push word ptr 1


;isub
pop bx 
pop ax 
sub ax,bx
push ax


;call facto
call facto


;imul
pop bx 
pop ax 
imul bx
push ax


;iload -2
push word ptr [bp-2]


;iadd
pop bx 
pop ax 
add ax,bx
push ax


;ireturn 6
pop ax
mov [bp+6], ax


FSI1:


;fermebloc 2
leave
ret 2


debut:
STARTUPCODE

main:

;ouvbloc 2
enter 2,0

;ecrireChaine "factorielle de : "
.DATA
mess0 DB "factorielle de : $"
.CODE
lea dx, mess0
push dx
call ecrch


;lireEnt -2
lea dx,[bp-2]
push dx
call lirent


;aLaLigne
call ligsuiv


;ecrireChaine "Egal a : "
.DATA
mess1 DB "Egal a : $"
.CODE
lea dx, mess1
push dx
call ecrch


;reserveRetour
sub sp,2


;iload -2
push word ptr [bp-2]


;call facto
call facto


;ecrireEnt
call ecrent


;aLaLigne
call ligsuiv


;queue
nop
EXITCODE
End debut
