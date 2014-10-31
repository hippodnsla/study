#include <stdio.h>
#include "org_hippo_sample_j2se_jni_MyJni.h"

JNIEXPORT void JNICALL Java_org_hippo_sample_j2se_jni_MyJni_display
  (JNIEnv *env, jobject obj) {
    printf("Hello World!");
 }

JNIEXPORT jdouble JNICALL Java_org_hippo_sample_j2se_jni_MyJni_sum
  (JNIEnv *, jobject obj, jdouble x, jdouble y) {
    return x+y;
 }
