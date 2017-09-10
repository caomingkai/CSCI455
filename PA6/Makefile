# Makefile for CS 455 extra credit assgt Spring 17
#
#     gmake getfiles
#        Copies or links assignment files to current directory
#
#     gmake ectest
#        Makes ectest executable
#
#     gmake submit
#        Submits the assignment.
#

# need to use gmake

HOME = /auto/home-scf-06/csci455/
ASSGTS = $(HOME)/assgts
ASSGTDIR = $(HOME)/assgts/ec

CXX = g++

CXXFLAGS = -ggdb -Wall
OBJS = ecListFuncs.o ectest.o

getfiles:
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/ecListFuncs.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/ecListFuncs.h
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/ectest.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Makefile
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/README

ectest: $(OBJS)
	$(CXX) $(CXXFLAGS) $(OBJS) -o ectest

$(OBJS): ecListFuncs.h


submit: 
	submit -user csci455 -tag ec README ecListFuncs.cpp
