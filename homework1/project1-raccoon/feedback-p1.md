# Feedback

Group raccoon: clastor, priyar4

Commit hash: 4124bd4d9634bcca2f56955f0067f076ecab2533

Raw score: 43 / 45

## Checkstyle

Score: 5 / 5

## DoubleLinkedList

Note that our tests use a different version of `IListMatcher`/`listContaining` that also checks the
    internal pointers of your list nodes. If you passed a functionality test previously, but lost
    points due to having an invalid linked list, that means your method doesn't set all the list
    node pointers correctly.

Score: 14 / 15

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testAddAndGetMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testAddIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testAlternatingAddAndRemove()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testDeleteBasic()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=0.5) testDeleteNearEndIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testDeleteOutOfBoundsThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testDeleteSingleElementList()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testDeleteUpdatesSize()</summary>
</details>

<details open>
<summary>❌ <b>FAIL</b>: (weight=0.5) testGetNearEndIsEfficient()</summary>

> <details>
> <summary>
> 
> ``` java
> org.opentest4j.AssertionFailedError: execution timed out after 15000 ms
> ```
> </summary>
> 
> ``` java
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:144)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:115)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:97)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:93)
>     at org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(Assertions.java:3236)
> ```
> </details>
> <details>
> <summary>
> 
> ``` java
>     at secret.TestSecretDoubleLinkedList.testGetNearEndIsEfficient(TestSecretDoubleLinkedList.java:117)
> ```
> </summary>
> 
> ``` java
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:628)
>     at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:117)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$7(TestMethodTestDescriptor.java:184)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:180)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:127)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:170)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:154)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:90)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:92)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$100(JUnitPlatformTestClassProcessor.java:77)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:73)
>     at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
>     at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
>     at com.sun.proxy.$Proxy2.stop(Unknown Source)
>     at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:131)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:155)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:137)
>     at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:404)
>     at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
>     at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
>     at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
>     at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
>     at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
>     at java.base/java.lang.Thread.run(Thread.java:835)
> ```
> </details>

</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testGetOutOfBoundsThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIndexOfAndContainsCorrectlyCompareItems()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIndexOfAndContainsMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIndexOfAndDelete()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testInsertAtEndIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testInsertAtFrontIsEfficient()</summary>
</details>

<details open>
<summary>❌ <b>FAIL</b>: (weight=1.0) testInsertEmptyAndSingleElement()</summary>

> <details>
> <summary>
> 
> ``` java
> java.lang.AssertionError: 
> Expected: is a list containing [b, a]
>      but: does not form a valid linked list
>     at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:18)
>     at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:6)
>     at datastructures.lists.TestDoubleLinkedList.testInsertEmptyAndSingleElement(TestDoubleLinkedList.java:317)
> ```
> </summary>
> 
> ``` java
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:628)
>     at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:117)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$7(TestMethodTestDescriptor.java:184)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:180)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:127)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:170)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:154)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:90)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:92)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$100(JUnitPlatformTestClassProcessor.java:77)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:73)
>     at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
>     at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
>     at com.sun.proxy.$Proxy2.stop(Unknown Source)
>     at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:131)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:155)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:137)
>     at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:404)
>     at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
>     at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
>     at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
>     at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
>     at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
>     at java.base/java.lang.Thread.run(Thread.java:835)
> ```
> </details>

</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testInsertNearEndIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testInsertOutOfBoundsThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorBasic()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorOnEmptyList()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorSingleElement()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testNullElement()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveFromEndIsEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveMultiple()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveOnEmptyListThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testSet()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testSetMany()</summary>
</details>

<details open>
<summary>❌ <b>FAIL</b>: (weight=0.5) testSetNearEndIsEfficient()</summary>

> <details>
> <summary>
> 
> ``` java
> org.opentest4j.AssertionFailedError: execution timed out after 15000 ms
> ```
> </summary>
> 
> ``` java
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:144)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:115)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:97)
>     at org.junit.jupiter.api.AssertTimeout.assertTimeoutPreemptively(AssertTimeout.java:93)
>     at org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(Assertions.java:3236)
> ```
> </details>
> <details>
> <summary>
> 
> ``` java
>     at secret.TestSecretDoubleLinkedList.testSetNearEndIsEfficient(TestSecretDoubleLinkedList.java:135)
> ```
> </summary>
> 
> ``` java
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:628)
>     at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:117)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$7(TestMethodTestDescriptor.java:184)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:180)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:127)
>     at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
>     at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
>     at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
>     at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
>     at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
>     at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:170)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:154)
>     at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:90)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:92)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$100(JUnitPlatformTestClassProcessor.java:77)
>     at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:73)
>     at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
>     at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
>     at com.sun.proxy.$Proxy2.stop(Unknown Source)
>     at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:131)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
>     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
>     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
>     at java.base/java.lang.reflect.Method.invoke(Method.java:567)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
>     at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:155)
>     at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:137)
>     at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:404)
>     at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
>     at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
>     at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
>     at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
>     at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
>     at java.base/java.lang.Thread.run(Thread.java:835)
> ```
> </details>

</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testSetOutOfBoundsThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testSetSingleElement()</summary>
</details>

## ArrayDictionary

Score: 15 / 15

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testContainsKeyBasic()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testEqualKeys()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testGetMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testGetNonexistentKeyThrowsException()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIterator()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorEndsCorrectly()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorHasNextAfterRemove()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorOverDictionaryWithOneElement()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorOverEmptyDictionary()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorPutDuplicateKeys()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorPutNewKeys()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorRemoveAll()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorRunsMultipleTimes()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorUnusualKeys()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testIteratorsAreIndependent()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testNullKey()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testNullValue()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testPutAndGetMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testPutDuplicateKeyAndRemove()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testPutDuplicateKeyMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testPutDuplicateKeyMultiple()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testPutRemoveMany()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveBasic()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveEfficient()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveNonexistent()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveNonexistentKeyMaintainsSize()</summary>
</details>

<details>
<summary>✔ <b>PASS</b>: (weight=1.0) testRemoveUsesOptimization()</summary>
</details>

## TestDoubleLinkedListDelete

Score: 9 / 10

❌ <b>FAIL</b>: (weight=1.0) AllOk  
> The tests you wrote incorrectly reported a correct implementation as broken.
> > ✔ <b>PASS</b>: testDeleteEmptyList()  
> > ✔ <b>PASS</b>: testDeleteExpected()  
> > ✔ <b>PASS</b>: testDeleteIndexOutOfBounds()  
> > ✔ <b>PASS</b>: testDeleteNull()  
> > ✔ <b>PASS</b>: testDeleteSingleElement()  
> > ✔ <b>PASS</b>: testDeleteTwoElements()  
> > ✔ <b>PASS</b>: testExample()  
> > ❌ <b>FAIL</b>: testFrontBackOneElement()  
> > ✔ <b>PASS</b>: testListBasic()  
> > ✔ <b>PASS</b>: testStringObjectOneAndTwoElement()  
> > ✔ <b>PASS</b>: testStringObjectsFrontBack()  

✔ <b>PASS</b>: (weight=1.0) MissingPrevNodeRepairLogic  
✔ <b>PASS</b>: (weight=1.0) MissingSizeUpdate  
✔ <b>PASS</b>: (weight=1.0) NoUpperBoundsCheck  
✔ <b>PASS</b>: (weight=1.0) NoLowerBoundsCheck  
✔ <b>PASS</b>: (weight=1.0) OffByOneError  
✔ <b>PASS</b>: (weight=1.0) MissingNextNodeRepairLogic  
✔ <b>PASS</b>: (weight=1.0) MissingBackFieldRepairLogic  
✔ <b>PASS</b>: (weight=1.0) ModifiesFrontField  
✔ <b>PASS</b>: (weight=1.0) IncorrectReturnValue  
✔ <b>PASS</b>: (weight=1.0) MissingFrontFieldRepairLogic  
