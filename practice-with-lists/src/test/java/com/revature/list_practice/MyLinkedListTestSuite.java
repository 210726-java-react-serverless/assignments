package com.revature.list_practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTestSuite {

    MyLinkedList<String> sut;

    @BeforeEach
    public void setUp() {
        sut = new MyLinkedList<>();
    }

    @AfterEach void cleanUp() {
        sut = null;
    }

    @Test
    public void add_returnsTrue_givenValidInput() {
        // Arrange
        String testInput = "test";

        // Act
        boolean addResult = sut.add(testInput);

        // Assert
        assertTrue(addResult);
        assertTrue(sut.contains(testInput));

    }

    @Test
    public void add_returnsFalse_givenNull() {

        // Act
        boolean addResult = sut.add(null);

        // Assert
        assertFalse(addResult);
        assertFalse(sut.contains(null));

    }

    @Test
    public void contains_returnsTrue_givenExistingElement() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean containsResult = sut.contains("test-2");

        // Assert
        assertTrue(containsResult);

    }

    @Test
    public void contains_returnsFalse_givenNonExistentElement() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean containsResult = sut.contains("test-4");

        // Assert
        assertFalse(containsResult);

    }

    @Test
    public void isEmpty_returnsTrue_whenListIsEmpty() {

        // Act
        boolean isEmptyResult = sut.isEmpty();

        // Assert
        assertTrue(isEmptyResult);

    }

    @Test
    public void isEmpty_returnsFalse_whenListIsPopulated() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean isEmptyResult = sut.isEmpty();

        // Assert
        assertFalse(isEmptyResult);

    }

    @Test
    public void remove_returnsTrue_whenListContainsElement() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean removeResult = sut.remove("test-2");

        // Assert
        assertTrue(removeResult);

    }

    @Test
    public void remove_returnsFalse_whenListDoesNotContainElement() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean removeResult = sut.remove("test-4");

        // Assert
        assertFalse(removeResult);

    }

    @Test
    public void poll_returnsAndRemovesHeadValue_whenListIsPopulated() {

        // Arrange
        String expectedResult = "test-1";

        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String pollResult = sut.poll();

        // Assert
        assertEquals(pollResult, expectedResult);
        assertFalse(sut.contains(expectedResult));

    }

    @Test
    public void poll_returnsNull_whenListIsEmpty() {

        // Act
        String pollResult = sut.poll();

        // Assert
        assertNull(pollResult);

    }

    @Test
    public void peek_returnsHeadValue_whenListIsPopulated() {

        // Arrange
        String expectedResult = "test-1";

        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String peekResult = sut.peek();

        // Assert
        assertEquals(peekResult, expectedResult);
        assertTrue(sut.contains(expectedResult));


    }

    @Test
    public void peek_returnsNull_whenListIsEmpty() {

        // Act
        String peekResult = sut.peek();

        // Assert
        assertNull(peekResult);

    }

    @Test
    public void containsLoop_returnsTrue_whenListContainsLoop() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("test-5");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeC;

        sut = new MyLinkedList<>(nodeA);


        // Act
        boolean containsLoopResult = sut.containsLoop();

        // Assert
        assertTrue(containsLoopResult);

    }

    @Test
    public void containsLoop_returnsTrue_whenListIsARingBuffer() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("test-5");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeA;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean containsLoopResult = sut.containsLoop();

        // Assert
        assertTrue(containsLoopResult);

    }

    @Test
    public void containsLoop_returnsFalse_whenListDoesNotContainLoop() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("test-5");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean containsLoopResult = sut.containsLoop();

        // Assert
        assertFalse(containsLoopResult);

    }

    @Test
    public void removeDuplicates_returnsNewListWithNoDuplicates_givenListWithDuplicates() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("b");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("c");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("d");
        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("c");
        MyLinkedList.Node<String> nodeG = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeH = new MyLinkedList.Node<>("e");
        MyLinkedList.Node<String> nodeI = new MyLinkedList.Node<>("e");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeF;
        nodeF.nextNode = nodeG;
        nodeG.nextNode = nodeH;
        nodeH.nextNode = nodeI;

        sut = new MyLinkedList<>(nodeA);

        MyLinkedList.Node<String> nodeJ = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeK = new MyLinkedList.Node<>("b");
        MyLinkedList.Node<String> nodeL = new MyLinkedList.Node<>("c");
        MyLinkedList.Node<String> nodeM = new MyLinkedList.Node<>("d");
        MyLinkedList.Node<String> nodeN = new MyLinkedList.Node<>("e");
        nodeJ.nextNode = nodeK;
        nodeK.nextNode = nodeL;
        nodeL.nextNode = nodeM;
        nodeM.nextNode = nodeN;

        MyLinkedList<String> expectedResult = new MyLinkedList<>(nodeJ);

        // Act
        MyLinkedList<String> removeDuplicatesResult = sut.removeDuplicates();

        // Assert
        assertEquals(removeDuplicatesResult, expectedResult);
        assertNotSame(removeDuplicatesResult, sut);

    }

    @Test
    public void removeDuplicates_returnsNewIdenticalList_givenListWithNoDuplicates() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("b");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("c");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("d");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("e");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;

        sut = new MyLinkedList<>(nodeA);

        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("a");
        MyLinkedList.Node<String> nodeG = new MyLinkedList.Node<>("b");
        MyLinkedList.Node<String> nodeH = new MyLinkedList.Node<>("c");
        MyLinkedList.Node<String> nodeI = new MyLinkedList.Node<>("d");
        MyLinkedList.Node<String> nodeJ = new MyLinkedList.Node<>("e");
        nodeF.nextNode = nodeG;
        nodeG.nextNode = nodeH;
        nodeH.nextNode = nodeI;
        nodeI.nextNode = nodeJ;

        MyLinkedList<String> expectedResult = new MyLinkedList<>(nodeF);


        // Act
        MyLinkedList<String> removeDuplicatesResult = sut.removeDuplicates();

        // Assert
        assertEquals(removeDuplicatesResult, expectedResult);
        assertNotSame(removeDuplicatesResult, sut);

    }

    @Test
    public void getKthToLast_returnsLastElement_givenZero() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("test-5");
        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("test-6");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeF;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String getKthToLastResult = sut.getKthToLast(0);

        // Assert
        assertEquals(getKthToLastResult, "test-6");

    }

    @Test
    public void getKthToLast_returnsCorrectElement_givenNonZero() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("test-5");
        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("test-6");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeF;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String getKthToLastResult = sut.getKthToLast(2);

        // Assert
        assertEquals(getKthToLastResult, "test-4");

    }

    @Test
    public void getKthToLast_returnsNull_givenNegativeInput() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String getKthToLastResult = sut.getKthToLast(-1);

        // Assert
        assertNull(getKthToLastResult);

    }

    @Test
    public void getKthToLast_returnsNull_givenOutOfBoundsInput() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("test-4");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;

        sut = new MyLinkedList<>(nodeA);

        // Act
        String getKthToLastResult = sut.getKthToLast(42);

        // Assert
        assertNull(getKthToLastResult);

    }

    @Test
    public void isPalindromicList_returnsTrue_correctly() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("R");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("A");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("C");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("E");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("C");
        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("A");
        MyLinkedList.Node<String> nodeG = new MyLinkedList.Node<>("R");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeF;
        nodeF.nextNode = nodeG;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean isPalindromicListResult = sut.isPalindromicList();

        // Assert
        assertTrue(isPalindromicListResult);

    }

    @Test
    public void isPalindromicList_returnsFalse_correctly() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("S");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("O");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("M");
        MyLinkedList.Node<String> nodeD = new MyLinkedList.Node<>("A");
        MyLinkedList.Node<String> nodeE = new MyLinkedList.Node<>("N");
        MyLinkedList.Node<String> nodeF = new MyLinkedList.Node<>("Y");
        MyLinkedList.Node<String> nodeG = new MyLinkedList.Node<>("T");
        MyLinkedList.Node<String> nodeH = new MyLinkedList.Node<>("E");
        MyLinkedList.Node<String> nodeI = new MyLinkedList.Node<>("S");
        MyLinkedList.Node<String> nodeJ = new MyLinkedList.Node<>("T");
        MyLinkedList.Node<String> nodeK = new MyLinkedList.Node<>("S");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        nodeC.nextNode = nodeD;
        nodeD.nextNode = nodeE;
        nodeE.nextNode = nodeF;
        nodeF.nextNode = nodeG;
        nodeG.nextNode = nodeH;
        nodeH.nextNode = nodeI;
        nodeI.nextNode = nodeJ;
        nodeJ.nextNode = nodeK;

        sut = new MyLinkedList<>(nodeA);

        // Act
        boolean isPalindromicListResult = sut.isPalindromicList();

        // Assert
        assertFalse(isPalindromicListResult);

    }

    @Test
    public void equals_returnsTrue_givenIdenticalList() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        sut = new MyLinkedList<>(nodeA);

        MyLinkedList.Node<String> nodeX = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeY = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeZ = new MyLinkedList.Node<>("test-3");
        nodeX.nextNode = nodeY;
        nodeY.nextNode = nodeZ;
        MyLinkedList<String> identicalList = new MyLinkedList<>(nodeX);

        // Act
        boolean equalsResult = sut.equals(identicalList);

        // Assert
        assertTrue(equalsResult);

    }

    @Test
    public void equals_returnsFalse_givenDifferentList() {

        // Arrange
        MyLinkedList.Node<String> nodeA = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeB = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeC = new MyLinkedList.Node<>("test-3");
        nodeA.nextNode = nodeB;
        nodeB.nextNode = nodeC;
        sut = new MyLinkedList<>(nodeA);

        MyLinkedList.Node<String> nodeX = new MyLinkedList.Node<>("test-1");
        MyLinkedList.Node<String> nodeY = new MyLinkedList.Node<>("test-2");
        MyLinkedList.Node<String> nodeZ = new MyLinkedList.Node<>("test-4");
        nodeX.nextNode = nodeY;
        nodeY.nextNode = nodeZ;
        MyLinkedList<String> differentList = new MyLinkedList<>(nodeX);

        // Act
        boolean equalsResult = sut.equals(differentList);

        // Assert
        assertFalse(equalsResult);

    }

}
